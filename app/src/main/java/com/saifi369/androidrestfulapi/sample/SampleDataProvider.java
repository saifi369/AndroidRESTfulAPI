package com.saifi369.androidrestfulapi.sample;

import com.saifi369.androidrestfulapi.model.CityDataItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {

    public static List<CityDataItem> cityDataItemList;
    public static Map<String,CityDataItem> dataItemMap;

    static {
        cityDataItemList =new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new CityDataItem(
                null,"Karachi",1,"Sindh",15000000,"Karachi is the capital city of Sindh province and the largest city in Pakistan according to area and population. It is the 4th most populous city in the world. It is a coastal city located on the banks of the Arabian Sea. Therefore its climate is affected by sea, with high winds blowing most of the time. The city is considered to be the financial capital of the country because trade activity is highest in the area and most companies have their headquarters situated here.",
                "karachi.jpg"));

        addItem(new CityDataItem(
                null,"Lahore",2,"Punjab",11126285,"Lahore is the capital city of Punjab province and the second largest city in Pakistan. Lahore lies on the banks of the river Ravi at an altitude of about 215 m above sea level, a few kilometers from the border with India. It is a historical city and is considered to be the cultural hub of Pakistan. Lahore has beautiful mosques, mausoleums, parks and various shopping spots.",
                "lahore.jpg"));

        addItem(new CityDataItem(
                null,"Faisalabad",3,"Punjab",3203846,"Faisalabad is a city in eastern Punjab. It is the industrial hub of Pakistan with the highest number of industrial units located here. As the area is surrounded by the Chenab river, various agricultural products are produced here including cotton, wheat, sugarcane, different fruits and vegetables.",
                "faisalabad.jpg"));

        addItem(new CityDataItem(
                null,"Rawalpindi",4,"Punjab",2098231,"Rawalpindi is a city located in the Potohar region of Punjab. It is called the twin city of Islamabad as they are located side by side. It has an area of 259 square km and a population of about 320.000.",
                "rawalpindi.jpg"));

        addItem(new CityDataItem(
                null,"Gujranwala",5,"Punjab",2027001,"Gujranwala is a city located in Punjab.The city was under the rule of Ghaznavid dynasty till 1193. It was then ruled by the Sikh Empire after the decline of the Mughal dynasty. The British captured the area in 1848 and built a network of railway lines to connect Gujranwala with other cities of the Punjab.",
                "gujranwala.jpg"));

        addItem(new CityDataItem(
                null,"Peshawar",6,"KPK",1970042,"Peshawar is the capital city of Khyber Pakhtunkhwa province. It lies in the broad valley near the eastern end of Khyber Pass, close to the border with Afghanistan. Peshawar's history goest back to 539 BC, making it the oldest city in Pakistan. It has been a gateway to most of the explorers and invaders of the past starting from Alexander the Great to the Mauryans, Huns, Muslim explorers Abdullah Shah Durrani, Mahmud Ghaznavi and the Mughals.",
                "peshawar.jpg"));

        addItem(new CityDataItem(
                null,"Multan",7,"Punjab",1871843,"Multan is a city located in central Punjab along the banks of Chenab river. It is called the \"City of Saints\" because of its large number of tombs and shrines. The region of Multan has been continuously inhabited for the past 5000 years. Multan is believed to have been the Malli capital that was conquered by Alexander the Great in 326 BCE as part of the Mallian Campaign. ",
                "multan.jpg"));

        addItem(new CityDataItem(
                null,"Hyderabad",8,"Sindh",1732693,"Hyderabad is a city located in Sindh. It is the second largest city in Sindh, after Karachi. It is said that Mian Ghulam Shah Kalhoro of the Kalhora Dynasty founded the city in 1768. A formal layout of the city laid is due to his son, Sarfraz Khan, in 1782. It had been under the rule of Muhammad bin Qasim until the British arrived.",
                "hyderabad.jpg"));

        addItem(new CityDataItem(
                null,"Islamabad",9,"Islamabad Capital Territory",1014825,"Islamabad is the capital city of Pakistan, located in the Potohar plateau below the Margalla Hills. It was built during the 1960s when the Greek architect Constantinos A.Doxiadis served as the lead architect of the project. The city's master plan divides it into 8 zones including administrative, diplomatic enclave, residential areas, educational sectors, industrial sectors, commercial areas, and rural and green areas.",
                "islamabad.jpg"));

        addItem(new CityDataItem(
                null,"Quetta",10,"Balochistan",1001205,"Quetta is the capital city of Balochistan province. The city is known as fruit garden of Pakistan as numerous fruits are produced here due to its location and climate. It lies at an altitude of 1680 m therefore it has a generally cold climate with snowfall in winter making the temperature drop to less than -10 degree Centigrade. However in summers, the weather remains mostly dry and warm.",
                "quetta.jpg"));

        addItem(new CityDataItem(
                null,"Bahawalpur",11,"Punjab",762001,"Founded in 1748, Bahawalpur was the capital of the former princely state of Bahawalpur, ruled by ruling Abbasi family of Nawabs until 1955. The Nawabs left a rich architectural legacy, and Bahawalpur is now known for its monuments dating from that period.",
                "bahawalpur.jpg"));

        addItem(new CityDataItem(
                null,"Sargodha",12,"Punjab",659005,"Sargodha was established by the British as a canal-colony in 1903, and was initially spelt Sargoda. Sargodha was badly affected by an outbreak of the plague in 1903, and experienced a milder outbreak in 1904.",
                "sargodha.jpg"));

        addItem(new CityDataItem(
                null,"Sialkot",13,"Punjab",655098,"Sialkot is believed to be site of ancient Sagala, a city razed by Alexander the Great in 326 BCE, and then made capital of the Indo-Greek kingdom by Menander I in the 2nd century BCE – a time during which the city greatly prospered as a major centre for trade and Buddhist thought.",
                "sialkot.jpg"));

        addItem(new CityDataItem(
                null,"Karachi",1,"Sindh",15000000,"Karachi is the capital city of Sindh province and the largest city in Pakistan according to area and population. It is the 4th most populous city in the world. It is a coastal city located on the banks of the Arabian Sea. Therefore its climate is affected by sea, with high winds blowing most of the time. The city is considered to be the financial capital of the country because trade activity is highest in the area and most companies have their headquarters situated here. The city has a formal economy estimated to be worth $113 billion/year as of 2014. Karachi collects over a third of Pakistan's tax revenue and generates approximately 20% of Pakistan's GDP. It was the capital after independence till 1968, when Islamabad became capital.",
                "karachi.jpg"));

        addItem(new CityDataItem(
                null,"Lahore",2,"Punjab",11126285,"Lahore is the capital city of Punjab province and the second largest city in Pakistan. Lahore lies on the banks of the river Ravi at an altitude of about 215 m above sea level, a few kilometers from the border with India. It is a historical city and is considered to be the cultural hub of Pakistan. Lahore has beautiful mosques, mausoleums, parks and various shopping spots.",
                "lahore.jpg"));

        addItem(new CityDataItem(
                null,"Faisalabad",3,"Punjab",3203846,"Lahore is the capital city of Punjab province and the second largest city in Pakistan. Lahore lies on the banks of the river Ravi at an altitude of about 215 m above sea level, a few kilometers from the border with India. It is a historical city and is considered to be the cultural hub of Pakistan. Lahore has beautiful mosques, mausoleums, parks and various shopping spots.",
                "faisalabad.jpg"));

        addItem(new CityDataItem(
                null,"Rawalpindi",4,"Punjab",2098231,"Rawalpindi is a city located in the Potohar region of Punjab. It is called the twin city of Islamabad as they are located side by side. It has an area of 259 square km and a population of about 320.000.",
                "rawalpindi.jpg"));

        addItem(new CityDataItem(
                null,"Gujranwala",5,"Punjab",2027001,"Gujranwala is a city located in Punjab.The city was under the rule of Ghaznavid dynasty till 1193. It was then ruled by the Sikh Empire after the decline of the Mughal dynasty. The British captured the area in 1848 and built a network of railway lines to connect Gujranwala with other cities of the Punjab.",
                "gujranwala.jpg"));

        addItem(new CityDataItem(
                null,"Peshawar",6,"KPK",1970042,"Peshawar is the capital city of Khyber Pakhtunkhwa province. It lies in the broad valley near the eastern end of Khyber Pass, close to the border with Afghanistan. Peshawar's history goest back to 539 BC, making it the oldest city in Pakistan. It has been a gateway to most of the explorers and invaders of the past starting from Alexander the Great to the Mauryans, Huns, Muslim explorers Abdullah Shah Durrani, Mahmud Ghaznavi and the Mughals.",
                "peshawar.jpg"));

        addItem(new CityDataItem(
                null,"Multan",7,"Punjab",1871843,"Multan is a city located in central Punjab along the banks of Chenab river. It is called the \"City of Saints\" because of its large number of tombs and shrines. The region of Multan has been continuously inhabited for the past 5000 years. Multan is believed to have been the Malli capital that was conquered by Alexander the Great in 326 BCE as part of the Mallian Campaign. ",
                "multan.jpg"));

        addItem(new CityDataItem(
                null,"Hyderabad",8,"Sindh",1732693,"Hyderabad is a city located in Sindh. It is the second largest city in Sindh, after Karachi. It is said that Mian Ghulam Shah Kalhoro of the Kalhora Dynasty founded the city in 1768. A formal layout of the city laid is due to his son, Sarfraz Khan, in 1782. It had been under the rule of Muhammad bin Qasim until the British arrived.",
                "hyderabad.jpg"));

        addItem(new CityDataItem(
                null,"Islamabad",9,"Islamabad Capital Territory",1014825,"Islamabad is the capital city of Pakistan, located in the Potohar plateau below the Margalla Hills. It was built during the 1960s when the Greek architect Constantinos A.Doxiadis served as the lead architect of the project. The city's master plan divides it into 8 zones including administrative, diplomatic enclave, residential areas, educational sectors, industrial sectors, commercial areas, and rural and green areas.",
                "islamabad.jpg"));

        addItem(new CityDataItem(
                null,"Quetta",10,"Balochistan",1001205,"Quetta is the capital city of Balochistan province. The city is known as fruit garden of Pakistan as numerous fruits are produced here due to its location and climate. It lies at an altitude of 1680 m therefore it has a generally cold climate with snowfall in winter making the temperature drop to less than -10 degree Centigrade. However in summers, the weather remains mostly dry and warm.",
                "quetta.jpg"));

        addItem(new CityDataItem(
                null,"Bahawalpur",11,"Punjab",762001,"Founded in 1748, Bahawalpur was the capital of the former princely state of Bahawalpur, ruled by ruling Abbasi family of Nawabs until 1955. The Nawabs left a rich architectural legacy, and Bahawalpur is now known for its monuments dating from that period.",
                "bahawalpur.jpg"));

        addItem(new CityDataItem(
                null,"Sargodha",12,"Punjab",659005,"Sargodha was established by the British as a canal-colony in 1903, and was initially spelt Sargoda. Sargodha was badly affected by an outbreak of the plague in 1903, and experienced a milder outbreak in 1904.",
                "sargodha.jpg"));

        addItem(new CityDataItem(
                null,"Sialkot",13,"Punjab",655098,"Sialkot is believed to be site of ancient Sagala, a city razed by Alexander the Great in 326 BCE, and then made capital of the Indo-Greek kingdom by Menander I in the 2nd century BCE – a time during which the city greatly prospered as a major centre for trade and Buddhist thought.",
                "sialkot.jpg"));

    }

    private static void addItem(CityDataItem cityDataItem){
        cityDataItemList.add(cityDataItem);
        dataItemMap.put(cityDataItem.getCityId(), cityDataItem);
    }

}
