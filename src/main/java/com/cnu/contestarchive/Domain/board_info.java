package com.cnu.contestarchive.Domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class board_info {

    Map<String, Object> board_info = new HashMap<>();

    /*
        !! 학과 이름이 명시된 경우, 단과대학인 경우에 추가하였음. !!

        ++ ~대학원, ~연구소, ~센터 등의 경우는 추가하지 않음.
        ++ 학생회 공지도 추가하지 않음
        ++ 학과 이름이 명시된 케이스여도 오랜 기간 업데이트가 없거나
            관련 없는 정보의 게시판일 경우 추가하지 않음.

        >> 정보화본부, 인재개발원, 소프트웨어중심사업단은 어떻게 하지.. 일단 넣어놓긴함

     */

    public board_info() {
        int[] Information_Technology_Department = {87, 6136};
        board_info.put("정보화본부", Information_Technology_Department);

        int[] Department_of_Electrical = {139};
        board_info.put("전기전자통신공학교육과", Department_of_Electrical);

        int[] Department_of_Construction_Engineering_Education = {171, 1705};
        board_info.put("건설공학교육과", Department_of_Construction_Engineering_Education);

        int[] Department_of_Korean_Language_and_Literature = {182};
        board_info.put("국어국문학과", Department_of_Korean_Language_and_Literature);

        int[] College_of_Education = {189};
        board_info.put("사범대학", College_of_Education);

        int[] Department_of_Organic_Materials_Engineering = {196, 198, 2080};
        board_info.put("유기재료공학과", Department_of_Organic_Materials_Engineering);

        int[] Department_of_Japanese_Language_and_Literature = {202};
        board_info.put("일어일문학과", Department_of_Japanese_Language_and_Literature);

        int[] Department_of_Physical_Education = {209, 211};
        board_info.put("체육교육과", Department_of_Physical_Education);

        int[] Department_of_Naval_Architecture_and_Ocean_Engineering = {228, 229};
        board_info.put("선박해양공학과", Department_of_Naval_Architecture_and_Ocean_Engineering);

        int[] Department_of_Mechanical_Engineering_Education = {247};
        board_info.put("기계공학교육과", Department_of_Mechanical_Engineering_Education);

        int[] College_of_Arts = {261};
        board_info.put("예술대학", College_of_Arts);

        int[] Department_of_Aerospace_Engineering = {274, 275, 286};
        board_info.put("항공우주공학과", Department_of_Aerospace_Engineering);

        int[] Department_of_Computer_Science_and_Engineering = {305, 306, 307, 324};
        board_info.put("컴퓨터융합학부", Department_of_Computer_Science_and_Engineering);

        int[] Department_of_Architectural_Engineering = {353, 358};
        board_info.put("건축공학과", Department_of_Architectural_Engineering);

        int[] College_of_Veterinary_Medicine = {401, 402, 443};
        board_info.put("수의과대학", College_of_Veterinary_Medicine);

        int[] Department_of_Painting = {435, 436};
        board_info.put("회화과", Department_of_Painting);

        int[] Department_of_Orchestral_Music = {448};
        board_info.put("관현악과", Department_of_Orchestral_Music);

        int[] Department_of_National_Security_Integrated_Studies = {498};
        board_info.put("국가안보융합학부", Department_of_National_Security_Integrated_Studies);

        int[] Department_of_Technology_Education = {529};
        board_info.put("기술교육과", Department_of_Technology_Education);

        int[] Department_of_Chemical_Engineering_Education = {544};
        board_info.put("화학공학교육과", Department_of_Chemical_Engineering_Education);

        int[] Department_of_French_Language_and_Literature = {580};
        board_info.put("불어불문학과", Department_of_French_Language_and_Literature);

        int[] Department_of_Education = {601, 603};
        board_info.put("교육학과", Department_of_Education);

        int[] Department_of_Political_Science_and_Diplomacy = {617};
        board_info.put("정치외교학과", Department_of_Political_Science_and_Diplomacy);

        int[] Department_of_History = {624};
        board_info.put("국사학과", Department_of_History);

        int[] Department_of_Social_Welfare = {679, 708};
        board_info.put("사회복지학과", Department_of_Social_Welfare);

        int[] Department_of_Music = {686, 688, 689};
        board_info.put("음악과", Department_of_Music);

        int[] College_of_Social_Sciences = {720};
        board_info.put("사회과학대학", College_of_Social_Sciences);

        int[] College_of_Nursing = {725, 2773, 5599, 5600, 5601, 5602, 5603, 5604, 5605, 5606, 5607, 5624};
        board_info.put("간호대학", College_of_Nursing);

        int[] Department_of_Library_and_Information_Science = {746, 763};
        board_info.put("문헌정보학과", Department_of_Library_and_Information_Science);

        int[] College_of_Life_Sciences = {792};
        board_info.put("생활과학대학", College_of_Life_Sciences);

        int[] Department_of_Biochemistry = {846};
        board_info.put("생화학과", Department_of_Biochemistry);

        int[] Department_of_Information_and_Statistics = {869, 5863};
        board_info.put("정보통계학과", Department_of_Information_and_Statistics);

        int[] Department_of_Mathematics_Education = {895};
        board_info.put("수학교육과", Department_of_Mathematics_Education);

        int[] Department_of_Media_and_Information = {944};
        board_info.put("언론정보학과", Department_of_Media_and_Information);

        int[] Department_of_Mathematics = {969};
        board_info.put("수학과", Department_of_Mathematics);

        int[] Department_of_Sociology = {1044};
        board_info.put("사회학과", Department_of_Sociology);

        int[] Department_of_Archaeology = {1057};
        board_info.put("고고학과", Department_of_Archaeology);

        int[] Department_of_History_1 = {1063};
        board_info.put("사학과", Department_of_History_1);

        int[] Department_of_Chinese_Language_and_Literature = {1083};
        board_info.put("중어중문학과", Department_of_Chinese_Language_and_Literature);

        int[] Department_of_Philosophy = {1125, 3928};
        board_info.put("철학과", Department_of_Philosophy);

        int[] Department_of_Electrical_Engineering = {1146, 2166};
        board_info.put("전기공학과", Department_of_Electrical_Engineering);

        int[] Department_of_Urban_and_Regional_Studies = {1170};
        board_info.put("도시·자치융합학과", Department_of_Urban_and_Regional_Studies);

        int[] Department_of_English_Education = {1184};
        board_info.put("영어교육과", Department_of_English_Education);

        int[] Department_of_International_Trade = {1192, 1193};
        board_info.put("무역학과", Department_of_International_Trade);

        int[] Department_of_Economics = {1211, 2096};
        board_info.put("경제학과", Department_of_Economics);

        int[] Department_of_Chemistry = {1228};
        board_info.put("화학과", Department_of_Chemistry);

        int[] Department_of_German_Language_and_Literature = {1247};
        board_info.put("독어독문학과", Department_of_German_Language_and_Literature);

        int[] Department_of_Civil_Engineering = {1261};
        board_info.put("토목공학과", Department_of_Civil_Engineering);

        int[] Department_of_Korean_Language_Education = {1307};
        board_info.put("국어교육과", Department_of_Korean_Language_Education);

        int[] College_of_Natural_Sciences = {1330};
        board_info.put("자연과학대학", College_of_Natural_Sciences);

        int[] Department_of_Apparel_Studies = {1419};
        board_info.put("의류학과", Department_of_Apparel_Studies);

        int[] Department_of_Consumer_Studies = {1423, 1424};
        board_info.put("소비자학과", Department_of_Consumer_Studies);

        int[] Department_of_Marine_Environmental_Science = {1442, 5740};
        board_info.put("해양환경과학과", Department_of_Marine_Environmental_Science);

        int[] Department_of_Food_and_Nutrition = {1489};
        board_info.put("식품영양학과", Department_of_Food_and_Nutrition);

        int[] Department_of_Astronomy_and_Space_Science = {1495, 1497};
        board_info.put("천문우주과학과", Department_of_Astronomy_and_Space_Science);

        int[] Department_of_Classical_Chinese_Language_and_Literature = {1528};
        board_info.put("한문학과", Department_of_Classical_Chinese_Language_and_Literature);

        int[] Department_of_Mechatronics_Engineering = {1575, 1579, 1581, 2172};
        board_info.put("메카트로닉스공학과", Department_of_Mechatronics_Engineering);

        int[] Department_of_Sports_Science = {1587};
        board_info.put("스포츠과학과", Department_of_Sports_Science);

        int[] Department_of_Asian_Business_and_International_Studies = {1620};
        board_info.put("아시아비즈니스국제학과", Department_of_Asian_Business_and_International_Studies);

        int[] College_of_Business = {1680, 1690, 1694, 1700, 1721};
        board_info.put("경상대학", College_of_Business);

        int[] Department_of_Physics = {1756};
        board_info.put("물리학과", Department_of_Physics);

        int[] Medical_School = {1824, 1845, 2003};
        board_info.put("의과대학", Medical_School);

        int[] Department_of_Linguistics = {1915, 1916};
        board_info.put("언어학과", Department_of_Linguistics);

        int[] Department_of_Speech_Language_Pathology = {2140};
        board_info.put("언어병리학과", Department_of_Speech_Language_Pathology);

        int[] Department_of_English_Language_and_Literature = {2241};
        board_info.put("영어영문학과", Department_of_English_Language_and_Literature);

        int[] Department_of_Sculpture = {2251, 2844};
        board_info.put("조소과", Department_of_Sculpture);

        int[] Department_of_Biological_and_Environmental_Chemistry = {2384};
        board_info.put("생명환경화학과", Department_of_Biological_and_Environmental_Chemistry);

        int[] College_of_Humanities = {2412, 2413, 2416, 2417, 2418, 2419, 2421, 2431, 2438};
        board_info.put("인문대학", College_of_Humanities);

        int[] Division_of_Liberal_Arts_and_Sciences = {2464};
        board_info.put("자유전공학부", Division_of_Liberal_Arts_and_Sciences);

        int[] College_of_Life_and_Systems_Science = {2495};
        board_info.put("생명시스템과학대학", College_of_Life_and_Systems_Science);

        int[] Department_of_Biological_Sciences = {2530};
        board_info.put("생물과학과", Department_of_Biological_Sciences);

        int[] Department_of_Microbial_Molecular_Life_Sciences = {2536};
        board_info.put("미생물분자생명과학과", Department_of_Microbial_Molecular_Life_Sciences);

        int[] Department_of_Materials_Science_and_Engineering = {2583};
        board_info.put("신소재공학과", Department_of_Materials_Science_and_Engineering);

        int[] Department_of_Dance = {2591};
        board_info.put("무용학과", Department_of_Dance);

        int[] Department_of_Applied_Chemical_Engineering = {2604};
        board_info.put("응용화학공학과", Department_of_Applied_Chemical_Engineering);

        int[] Department_of_Mechanical_Engineering = {2674};
        board_info.put("기계공학부", Department_of_Mechanical_Engineering);

        int[] College_of_Agricultural_and_Life_Sciences = {2684};
        board_info.put("농업생명과학대학", College_of_Agricultural_and_Life_Sciences);

        int[] Department_of_Plant_Resources = {2749};
        board_info.put("식물자원학과", Department_of_Plant_Resources);

        int[] Department_of_Horticulture = {2754};
        board_info.put("원예학과", Department_of_Horticulture);

        int[] Department_of_Food_Engineering = {2850};
        board_info.put("식품공학과", Department_of_Food_Engineering);

        int[] Department_of_Agricultural_Economics = {2860};
        board_info.put("농업경제학과", Department_of_Agricultural_Economics);

        int[] Department_of_Applied_Biology = {2897};
        board_info.put("응용생물학과", Department_of_Applied_Biology);

        int[] Department_of_Regional_Environmental_Civil_Engineering = {2980};
        board_info.put("지역환경토목학과", Department_of_Regional_Environmental_Civil_Engineering);

        int[] Institute_of_Human_Resource_Development = {3089, 3113, 3114, 3117, 3123, 3124, 3126, 3128};
        board_info.put("인재개발원", Institute_of_Human_Resource_Development);

        int[] Department_of_Forest_Environment_and_Resource_Science = {3130};
        board_info.put("산림환경자원학과", Department_of_Forest_Environment_and_Resource_Science);

        int[] Department_of_Public_Administration = {3236};
        board_info.put("행정학부", Department_of_Public_Administration);

        int[] College_of_Pharmacy = {3373};
        board_info.put("약학대학", College_of_Pharmacy);

        int[] School_of_Business_Administration = {3792};
        board_info.put("경영학부", School_of_Business_Administration);

        int[] Department_of_Astrogeology = {3851};
        board_info.put("우주지질학과", Department_of_Astrogeology);

        int[] Department_of_BioAI_Convergence = {3950};
        board_info.put("바이오AI융합학과", Department_of_BioAI_Convergence);

        int[] Department_of_Autonomous_Navigation_System_Engineering = {4383, 4388};
        board_info.put("자율운항시스템공학과", Department_of_Autonomous_Navigation_System_Engineering);

        int[] Department_of_Smart_City_Architecture_Engineering = {4479, 4484};
        board_info.put("스마트시티건축공학과", Department_of_Smart_City_Architecture_Engineering);

        int[] Department_of_Artificial_Intelligence = {4630, 4631, 4645};
        board_info.put("인공지능학과", Department_of_Artificial_Intelligence);

        int[] Department_of_Bioinformatics = {5057};
        board_info.put("생명정보융합학과", Department_of_Bioinformatics);

        int[] Software_Centered_University_Initiative = {5147};
        board_info.put("소프트웨어중심사업단", Software_Centered_University_Initiative);

        int[] College_of_Engineering = {5269};
        board_info.put("공과대학", College_of_Engineering);

        int[] Department_of_Radio_Information_and_Communication_Engineering = {5296};
        board_info.put("전파정보통신공학부", Department_of_Radio_Information_and_Communication_Engineering);

        int[] Department_of_Polymer_Engineering = {5306};
        board_info.put("고분자공학과", Department_of_Polymer_Engineering);

        int[] Department_of_Environmental_Engineering = {5345};
        board_info.put("환경공학과", Department_of_Environmental_Engineering);

        int[] International_Studies_Program = {5695};
        board_info.put("국제학부", International_Studies_Program);

        int[] Department_of_Electrical_Engineering_1 = {5791};
        board_info.put("전자공학과", Department_of_Electrical_Engineering_1);

        int[] Department_of_Technology_Commercialization_and_Convergence = {5807};
        board_info.put("기술실용화융합학과", Department_of_Technology_Commercialization_and_Convergence);


    }
}
