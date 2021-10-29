package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.Date;
import java.util.concurrent.*;

@Controller
@Slf4j
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/async")
    public DeferredResult<ResponseEntity<?>> handleDefRequest() {
        log.info("Received deferred request");

        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
        ForkJoinPool.commonPool().submit(() -> {
            log.info("Processing request in separate thread");
            try {
                Thread.sleep(6000);

            } catch (InterruptedException interruptedException) {

            }
            output.setResult(ResponseEntity.ok("ok"));
        });
        log.info("Free http worker thread");
        return output;
    }

    @GetMapping(value = "/async-callable")
    @ResponseBody
    public Callable<String> handleCallableRequest() {
        log.info("Received callable request");

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("Processing request in separate thread");
                Thread.sleep(6000);
                return "ok";
            }
        };

        log.info("Free http worker thread");

        return callable;
    }

    private ExecutorService executor
            = Executors.newCachedThreadPool();

    @GetMapping("/rbe")
    public ResponseEntity<ResponseBodyEmitter> handleRbe() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        executor.execute(() -> {
            try {
                emitter.send(
                        "/rbe" + " @ " + new Date(), MediaType.TEXT_PLAIN);
                Thread.sleep(5000);
                emitter.send(
                        "/rde" +
                                "" + " @ " + new Date(), MediaType.TEXT_PLAIN);
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return new ResponseEntity(emitter, HttpStatus.OK);
    }

    @GetMapping("/sse")
    public SseEmitter handleSse() {
        SseEmitter emitter = new SseEmitter();
        executor.execute(() -> {
            try {
                emitter.send("/sse" + " @ " + new Date());
                Thread.sleep(5000);
                emitter.send("/sse" + " @ " + new Date());
                // we could send more events
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }

    @GetMapping("/srb")
    public ResponseEntity<StreamingResponseBody> handleSrb() {
        StreamingResponseBody stream = out -> {
            String msg = "/srb" + " @ " + new Date();
            out.write(msg.getBytes());
        };
        return new ResponseEntity(stream, HttpStatus.OK);
    }


}