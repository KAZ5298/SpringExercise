package katachi.spring.exercise.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
	
	// EX5.
	// 性別
	public Map<String, Integer> getGenderMap() {
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		genderMap.put("男性", 1);
		genderMap.put("女性", 2);
		genderMap.put("その他", 3);
		return genderMap;
	}
	
	// 血液型
	public Map<String, Integer> getBloodtypeMap() {
		Map<String, Integer> bloodtypeMap = new LinkedHashMap<>();
		bloodtypeMap.put("Ａ型", 1);
		bloodtypeMap.put("Ｂ型", 2);
		bloodtypeMap.put("Ｏ型", 3);
		bloodtypeMap.put("ＡＢ型", 4);
		bloodtypeMap.put("不明", 5);
		return bloodtypeMap;
	}
	
	// 学習内容
	public Map<String, String> getStudyMap() {
		Map<String, String> studyMap = new LinkedHashMap<>();
		studyMap.put("Java", "Java");
		studyMap.put("PHP", "PHP");
		studyMap.put("HTML", "HTML");
		studyMap.put("デザイン", "デザイン");
		studyMap.put("その他", "その他");
		return studyMap;
	}
	
}