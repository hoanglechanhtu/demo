package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
public class TestRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Solution solution = new Solution();
        solution.validTree(1386, new int[][]{{1031,1189},{1328,500},{1331,752},{868,255},{955,598},{398,113},{493,1346},{449,232},{112,688},{1310,218},{853,457},{629,493},{337,285},{346,477},{1065,146},{98,1351},{1365,823},{549,435},{465,210},{1201,16},{1111,871},{356,633},{188,988},{152,141},{1201,143},{60,645},{869,109},{611,620},{448,114},{475,143},{389,486},{897,970},{115,1008},{508,1212},{471,681},{612,795},{84,9},{55,1093},{913,670},{34,475},{173,233},{853,136},{891,438},{479,314},{600,1383},{392,501},{480,808},{644,804},{1081,85},{1339,992},{419,379},{651,1379},{556,649},{1076,532},{672,521},{297,436},{909,764},{1137,990},{1385,1060},{128,400},{1000,410},{676,1306},{1257,204},{293,476},{273,403},{370,1192},{337,742},{985,1030},{109,905},{167,1321},{194,831},{673,640},{687,1174},{314,26},{495,352},{967,340},{524,101},{89,363},{1290,315},{583,584},{116,52},{159,488},{1349,1364},{167,132},{1105,9},{722,700},{1123,926},{420,1279},{411,621},{645,512},{1304,69},{857,1217},{1203,543},{1301,41},{1051,965},{816,292},{658,1270},{1012,848},{1039,615},{865,482},{610,540},{698,953},{247,412},{685,1161},{85,895},{912,1278},{1082,489},{175,946},{803,624},{643,821},{253,144},{1331,144},{575,1094},{692,505},{801,690},{1019,780},{1291,340},{335,224},{279,1056},{843,585},{810,1079},{522,943},{18,55},{1317,579},{940,1372},{1280,1101},{409,1356},{1237,1276},{812,1340},{135,326},{879,859},{231,136},{306,494},{626,894},{23,596},{1116,606},{467,1145},{1143,1171},{368,349},{1110,1200},{800,872},{1226,1072},{139,753},{866,1068},{1343,1136},{1054,981},{659,1380},{1147,828},{8,292},{76,46},{586,765},{670,1014},{988,700},{1270,26},{1165,166},{1146,867},{540,285},{439,887},{506,32},{359,580},{710,575},{72,427},{752,854},{1162,92},{519,398},{293,826},{964,645},{566,56},{227,1290},{1075,92},{590,789},{931,646},{552,1003},{1354,715},{241,525},{1367,331},{39,951},{286,663},{214,988},{100,887},{1048,421},{144,1280},{423,568},{173,712},{1230,301},{43,842},{372,1056},{1134,731},{80,104},{126,913},{539,64},{510,13},{865,341},{871,346},{621,239},{1248,836},{244,860},{1135,404},{801,342},{184,39},{385,222},{180,1311},{789,408},{35,1377},{753,953},{139,74},{215,1300},{1131,44},{927,300},{756,331},{1353,722},{481,758},{321,1128},{898,708},{1256,419},{978,141},{982,1139},{320,680},{1277,1344},{591,516},{499,173},{297,985},{570,694},{1259,348},{347,307},{299,843},{460,1090},{793,320},{70,1121},{541,884},{1311,807},{960,901},{1255,590},{989,659},{147,422},{909,1076},{13,918},{1225,1276},{902,1356},{669,1127},{806,1059},{90,1196},{90,1250},{122,1310},{1003,1031},{646,134},{1375,8},{333,210},{272,539},{545,854},{1107,455},{23,1048},{243,1045},{587,1230},{417,987},{65,1276},{492,45},{1262,902},{22,1042},{1235,333},{967,7},{560,267},{899,292},{176,170},{489,444},{802,620},{799,1134},{952,826},{965,57},{1218,623},{121,138},{808,410},{387,383},{163,390},{916,790},{266,665},{927,1044},{690,1008},{839,912},{610,426},{734,988},{1109,17},{209,1276},{602,372},{828,1257},{732,910},{737,791},{223,799},{1240,1191},{1236,363},{836,1228},{1301,310},{997,142},{407,718},{948,1005},{236,256},{1146,544},{890,1088},{723,934},{937,11},{705,25},{690,349},{892,226},{21,371},{70,780},{673,180},{612,893},{745,1250},{1340,1174},{517,749},{709,725},{1019,597},{382,1286},{49,967},{288,1079},{368,1289},{1128,1283},{1090,910},{1272,1266},{965,979},{410,944},{5,1354},{1320,724},{1252,289},{894,1120},{1281,320},{386,846},{1350,123},{240,8},{167,495},{201,1069},{742,1222},{536,286},{639,46},{475,530},{1337,1188},{838,1079},{422,845},{396,988},{1312,162},{807,1286},{595,383},{1003,26},{1065,1139},{957,320},{1046,1305},{318,1336},{1024,1083},{462,631},{1254,395},{943,168},{504,626},{511,359},{696,136},{959,944},{861,1120},{651,36},{999,1364},{995,642},{459,871},{1378,201},{855,1188},{1129,1068},{173,1022},{1380,612},{1224,1335},{964,941},{608,1011},{468,503},{180,1140},{681,1136},{561,355},{499,1185},{110,1091},{248,1256},{534,193},{118,1115},{708,205},{960,21},{562,94},{600,40},{1086,792},{628,810},{918,433},{663,319},{208,400},{808,743},{1009,845},{523,398},{379,1167},{443,421},{573,50},{20,364},{409,1031},{213,1095},{1240,246},{250,560},{811,1103},{52,83},{368,427},{802,433},{595,463},{92,1180},{99,1228},{799,786},{1302,610},{214,611},{244,76},{331,325},{1008,432},{222,1141},{343,16},{736,1209},{1294,580},{1141,1146},{249,153},{382,385},{712,821},{561,179},{206,331},{993,385},{575,1120},{102,435},{592,60},{1233,509},{437,363},{340,985},{692,882},{1012,733},{1100,1314},{639,1108},{552,155},{948,1261},{671,213},{1215,874},{293,1016},{1262,29},{351,242},{147,1010},{1305,303},{563,941},{1153,1368},{836,1157},{1097,1193},{496,773},{782,1238},{177,421},{273,1339},{456,599},{562,709},{813,595},{246,151},{1328,1100},{1319,1146},{311,859},{344,1091},{1126,630},{61,422},{262,127},{331,389},{855,44},{452,843},{1168,73},{351,1232},{255,828},{839,567},{1014,646},{798,63},{404,114},{1274,23},{93,490},{908,354},{12,194},{435,339},{851,91},{257,279},{1221,1294},{1074,949},{503,236},{1105,1116},{262,534},{1277,145},{383,66},{485,1166},{949,223},{1025,917},{237,1369},{4,513},{400,632},{847,345},{1330,19},{1310,975},{1237,581},{1025,1247},{575,1332},{0,839},{1054,1302},{130,297},{1085,817},{349,291},{420,1183},{753,639},{1131,860},{554,973},{41,142},{542,393},{612,156},{1247,952},{342,74},{641,945},{754,364},{541,780},{139,252},{325,518},{558,1096},{476,799},{814,1221},{1360,646},{782,171},{677,436},{808,1261},{966,862},{1217,171},{500,1113},{462,1025},{624,230},{685,604},{1211,129},{911,54},{87,1284},{1159,1176},{242,23},{841,465},{62,1145},{63,667},{399,383},{928,1297},{31,1042},{218,224},{194,895},{724,68},{179,151},{979,1330},{812,1256},{191,1099},{511,275},{640,246},{444,1175},{1238,167},{1146,1147},{174,1349},{691,1053},{591,1076},{236,476},{1156,981},{7,999},{261,997},{31,994},{1381,12},{671,73},{954,283},{1082,959},{814,1136},{1166,1317},{590,1046},{696,1224},{788,272},{275,1168},{926,146},{721,497},{697,74},{789,251},{741,297},{126,462},{804,841},{814,79},{419,1115},{916,34},{1241,318},{810,1247},{963,663},{281,614},{4,351},{1103,513},{538,754},{732,430},{993,1100},{587,563},{713,478},{248,209},{240,126},{130,1260},{906,471},{1112,170},{492,461},{669,76},{534,1005},{555,554},{1078,1341},{664,647},{447,348},{1065,729},{419,976},{1209,59},{714,530},{1193,732},{398,251},{1145,573},{651,137},{927,556},{852,208},{1007,91},{1228,853},{452,264},{1195,1104},{677,213},{912,193},{1150,954},{1080,647},{1304,1332},{549,620},{931,926},{609,655},{802,769},{867,310},{274,948},{755,397},{1089,1348},{1108,198},{7,975},{638,943},{1181,1133},{829,217},{1248,435},{1083,965},{364,557},{1067,810},{276,1370},{415,1125},{640,225},{353,1268},{994,1256},{575,1003},{859,59},{1101,354},{1160,941},{1252,809},{1325,670},{362,609},{67,75},{63,553},{760,1315},{244,1177},{131,854},{1120,599},{445,465},{487,70},{756,706},{706,1114},{382,123},{1220,1086},{973,692},{332,475},{1234,1347},{1318,682},{55,319},{521,424},{929,307},{691,538},{1232,239},{964,566},{1028,653},{23,24},{616,793},{54,380},{149,1126},{276,74},{179,134},{1274,692},{627,311},{598,1357},{781,97},{95,1233},{273,752},{782,51},{1314,668},{400,615},{1255,339},{623,1042},{223,472},{811,1002},{487,86},{1111,910},{272,43},{470,345},{152,898},{837,1057},{558,1358},{286,488},{369,783},{670,1032},{299,148},{891,679},{1235,19},{329,1111},{517,892},{1184,799},{497,356},{10,1057},{1091,1259},{1141,1156},{726,602},{1212,175},{1290,682},{915,435},{601,758},{343,78},{1308,175},{1384,1361},{560,259},{1230,244},{133,948},{417,539},{1180,649},{739,1378},{1140,1090},{798,551},{139,1351},{916,754},{978,62},{990,253},{141,492},{231,645},{766,287},{695,791},{838,641},{20,726},{979,1130},{1323,292},{269,322},{705,140},{801,916},{899,363},{255,1296},{83,672},{921,411},{574,394},{904,507},{774,71},{1126,910},{1385,658},{332,92},{409,666},{208,534},{480,809},{566,843},{1242,813},{623,232},{879,661},{639,782},{1000,1243},{494,467},{647,212},{532,901},{1165,1122},{131,613},{87,354},{8,1204},{440,454},{115,793},{1253,1153},{204,1132},{1291,645},{462,496},{977,1247},{839,650},{304,949},{1151,580},{760,539},{226,341},{411,1042},{1227,51},{1160,267},{456,263},{940,773},{1338,1352},{108,247},{402,1016},{745,558},{9,182},{1211,1007},{334,1148},{1177,692},{1066,22},{460,442},{1384,205},{451,352},{958,667},{1086,925},{689,518},{337,43},{370,995},{1107,1219},{1243,1318},{362,493},{571,1086},{1235,1291},{691,1207},{404,475},{1030,380},{1304,405},{612,1084},{788,1122},{272,1371},{831,1330},{1180,131},{626,268},{1096,109},{1323,912},{1001,729},{484,461},{1055,1200},{1084,1246},{1265,1104},{202,536},{409,635},{1034,293},{243,429},{1147,727},{271,893},{116,765},{955,493},{386,798},{402,1102},{839,260},{816,108},{1139,47},{379,47},{1173,1182},{78,263},{111,224},{1271,1228},{396,656},{138,1313},{164,759},{392,995},{636,978},{125,895},{1366,603},{1253,375},{476,158},{1109,5},{142,360},{573,186},{1380,904},{534,813},{930,1199},{829,600},{1280,925},{678,703},{1254,374},{800,156},{196,153},{1112,924},{976,524},{1299,212},{790,153},{707,603},{941,375},{884,1127},{312,207},{33,1150},{499,356},{622,823},{721,737},{55,340},{346,570},{705,1121},{837,219},{454,238},{330,770},{740,651},{709,706},{14,804},{1153,1176},{1091,1039},{631,608},{822,199},{693,1140},{1026,405},{395,122},{1357,1169},{1021,639},{1064,778},{527,952},{186,1203},{106,1383},{1051,316},{154,269},{204,345},{377,561},{343,943},{741,3},{897,1150},{794,590},{57,827},{1032,112},{840,848},{1043,125},{1281,1148},{1047,492},{1296,90},{1190,507},{1089,1002},{376,1343},{1182,1064},{354,833},{1209,766},{1224,83},{1233,979},{1233,730},{1339,103},{983,599},{871,1272},{657,1033},{541,1169},{111,416},{682,548},{1307,36},{1208,51},{1276,1295},{509,228},{250,481},{898,61},{435,784},{367,640},{528,1330},{1164,945},{1295,1018},{1106,1127},{531,392},{801,137},{975,388},{503,907},{192,125},{111,106},{97,810},{792,1077},{746,1094},{707,1138},{1030,238},{676,489},{923,1052},{1016,156},{483,430},{503,498},{210,589},{491,364},{399,506},{1275,376},{942,1109},{110,1170},{618,1247},{538,637},{1190,48},{834,204},{170,1026},{744,148},{906,573},{1306,455},{911,757},{507,1085},{1068,1197},{230,1175},{935,652},{493,1264},{63,1107},{340,1268},{1013,669},{197,1084},{1305,1035},{1263,1001},{537,1142},{569,724},{410,703},{1341,486},{229,326},{639,10},{824,839},{712,38},{270,161},{588,193},{1310,441},{77,1182},{771,504},{875,897},{1244,674},{186,896},{331,1351},{1010,199},{635,59},{429,589},{704,199},{593,1083},{727,900},{404,559},{991,1092},{1096,903},{399,849},{308,709},{688,358},{773,178},{1038,238},{454,1324},{1158,88},{135,221},{568,773},{470,474},{188,1355},{1374,254},{54,165},{938,170},{933,1304},{1007,622},{769,326},{1234,91},{660,156},{1100,280},{520,1368},{1104,985},{1135,779},{877,1252},{949,966},{119,1032},{33,623},{1194,722},{51,825},{1171,361},{1037,1133},{1336,717},{1273,1171},{489,84},{1087,1306},{425,476},{946,942},{566,1020},{191,788},{258,465},{1002,1029},{928,518},{730,1036},{1336,23},{1144,342},{1239,224},{968,162},{642,149},{1313,1334},{889,291},{785,1185},{573,664},{1046,885},{494,482},{466,757},{148,748},{294,346},{594,940},{922,1324},{878,41},{418,1059},{842,393},{42,1192},{416,783},{197,211},{328,366},{1037,817},{1098,600},{1219,1173},{1068,716},{900,532},{952,537},{747,137},{254,588},{296,999},{1027,787},{1313,422},{947,395},{399,1154},{16,207},{835,187},{1195,1234},{1071,1192},{1155,110},{1269,455},{235,541},{307,1239},{703,648},{51,930},{806,75},{357,594},{715,1384},{390,891},{914,452},{124,885},{203,628},{1055,1361},{122,1129},{6,314},{634,129},{737,735},{936,290},{281,387},{284,1113},{66,216},{987,1158},{365,895},{1065,394},{962,654},{160,481},{32,1033},{1069,524},{876,822},{675,903},{162,94},{390,625},{234,157},{373,107},{761,900},{676,1206},{571,1231},{499,260},{500,366},{343,1073},{269,301},{508,832},{1307,157},{908,187},{11,703},{787,234},{464,603},{1092,416},{487,796},{1316,677},{772,103},{478,472},{734,105},{887,1358},{1145,886},{40,1366},{662,1209},{631,768},{117,1167},{1124,1221},{515,450},{991,962},{1338,229},{526,676},{1133,1125},{1284,313},{260,1117},{1058,559},{324,918},{226,685},{774,1067},{428,728},{438,262},{61,104},{298,1179},{226,818},{367,431},{659,974},{687,1012},{720,162},{645,75},{776,990},{775,342},{226,1213},{1362,384},{951,669},{629,1377},{936,946},{1163,900},{684,812},{592,873},{1138,619},{1186,1072},{653,311},{15,489},{820,906},{706,923},{75,1143},{541,401},{1308,674},{1062,94},{220,795},{705,1292},{590,863},{324,1382},{724,279},{96,857},{185,255},{1277,48},{903,767},{686,227},{277,236},{1118,847},{1072,1264},{593,996},{446,113},{808,844},{979,1342},{757,458},{659,858},{1215,859},{1061,1053},{1128,319},{414,1257},{755,608},{1298,639},{936,172},{972,888},{1061,282},{840,932},{1085,195},{841,819},{883,964},{914,702},{1267,1081},{984,185},{1166,417},{1041,1122},{736,797},{585,164},{270,1164},{1214,1046},{535,1308},{1287,694},{961,812},{723,1053},{399,490},{1023,706},{618,939},{450,331},{1279,1281},{644,1229},{990,1345},{279,1063},{428,355},{1033,1017},{183,810},{770,908},{740,453},{1282,696},{150,520},{605,109},{1070,859},{81,263},{1322,656},{799,384},{1198,1232},{660,298},{244,169},{378,438},{489,751},{1049,732},{451,1006},{1146,1309},{1088,363},{1048,469},{763,606},{624,1303},{1249,3},{28,1134},{998,269},{720,1327},{652,1097},{1047,546},{69,266},{529,30},{1251,1356},{295,131},{572,1339},{27,305},{1369,680},{502,569},{406,370},{1363,32},{992,805},{240,302},{107,1363},{724,1223},{775,699},{407,286},{533,1227},{338,998},{762,702},{1020,1050},{27,1001},{23,711},{309,403},{1258,1182},{327,1134},{583,299},{2,221},{1119,300},{287,391},{607,630},{547,1214},{626,578},{1045,617},{1131,189},{195,53},{187,950},{843,1288},{564,536},{734,888},{320,582},{282,1205},{1149,198},{1151,1359},{956,145},{738,653},{390,190},{576,243},{232,278},{546,1373},{971,128},{844,864},{1326,186},{833,1285},{1293,1364},{1374,870},{919,420},{19,1},{529,517},{986,1381},{679,1172},{683,184},{485,473},{1207,1187},{719,980},{1109,120},{1262,830},{187,1210},{930,58},{904,1300},{287,920},{104,577},{856,1112},{1325,1245},{1216,82},{413,688},{216,881},{719,411},{288,701},{339,815},{472,317},{777,107},{181,897},{969,1171},{1004,638},{1182,265},{576,350},{514,161},{324,550},{1333,911},{858,880},{200,395},{1071,336},{1103,850},{1146,750},{466,381},{1306,1329},{843,82},{467,241},{782,323},{1020,1152},{1040,259},{565,287},{1165,1202},{37,1222},{245,887},{1173,1178},{874,1376},{797,1015},{431,434}});
    }
    public static class Solution {
        /**
         * @param n: An integer
         * @param edges: a list of undirected edges
         * @return: true if it's a valid tree, or false
         */
        public boolean validTree(int n, int[][] edges) {
            // write your code here
            if (fastPass(n, edges)) return true;
            adjustEdges(edges);
            return check(n, edges);
        }


        boolean fastPass(int n, int[][] edges) {
            return n == 1 && edges.length == 0;
        }

        void adjustEdges(int[][] edges){
            Arrays.sort(edges, Comparator.comparing(x -> x[0]));
            for (int i = 0; i < edges.length; i ++) {
                if (edges[i][0] > edges[i][1]) {
                    int temp = edges[i][0];
                    edges[i][0] = edges[i][1];
                    edges[i][1] = temp;
                }
            }
        }
        boolean check(int n, int[][] edges) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i ++) {
                List<Integer> list = new ArrayList();
                map.put(i, list);
            }
            for (int i = 0; i < edges.length; i ++) {
                map.get(edges[i][0]).add(edges[i][1]);
            }
            boolean[] isVisited = new boolean[n];
            Arrays.fill(isVisited, false);
            for (int i = 0; i < edges.length; i ++) {
                isVisited[edges[i][1]] = true;
            }
            int root = -1;
            for (int i = 0; i < edges.length; i ++) {
                if (!isVisited[i] && root != -1) {
                    int x = edges[i][0];
                    int y = edges[i][1];
                    return false;
                }
                if (!isVisited[i]) root = i;
            }
            if (root == -1) return false;
            int count = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.addFirst(root);
            while(!queue.isEmpty()) {
                int node = queue.removeLast();
                count ++;
                map.get(node).forEach(val -> {
                    queue.addFirst(val);
                });
            }
            return count == n;
        }
    }
}
