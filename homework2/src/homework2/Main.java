package homework2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static myPackage.MyScanner.*;

public class Main {

	public static void main(String[] args) {
		int taskNumber;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list , 2, 1, 1, 1, 2, 3, 3, 2, 3, 4, 5, 6, 7);
		HashMap<String, Integer> dictionary = new HashMap<>();
		dictionary.put("k", 2);
		dictionary.put("y", 2);
		dictionary.put("i", 1);
		dictionary.put("t", 3);
		System.out.println("Пожалуйста, выберите номер задачи: ");
		System.out.println("1 - Задача 1");
		System.out.println("2 - Задача 2");
		System.out.println("3 - Задача 3");
		
		taskNumber = scanInt();
		
		
		switch (taskNumber) {
		case 1:
			task1(list);
			break;
		case 2:
			task2(dictionary);
			break;
		case 3:
			
			task3();
			break;
		}
	}
	public static <T> void task1(Collection<T> collection){
		System.out.println("Вывод работы 1 задачи.");
		System.out.println("То что пришло:");
		System.out.println(collection);
		System.out.println("То что получилось:");
		System.out.println(new HashSet<>(collection));
		//return new HashSet<>(collection);
	}
	public static <K, V> Map<V, Collection<K>> task2(Map<? extends K, ? extends V> map){
		Map<V, Collection<K>> resultMap= new HashMap<>();
		Set<K> keys = (Set<K>) map.keySet();
		for(K key : keys) {
			V value = map.get(key);
			resultMap.compute(value, (v,ks) -> {
				if(ks == null){
					ks = new HashSet<>();
				}
				ks.add(key);
				return ks;
			});
		}
		System.out.println("То что пришло:");
		System.out.println(map);
		System.out.println("Вывод 2 задачи:");
		System.out.println(resultMap);
		return resultMap;
	}
	public static void task3() {
			// "Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"
		int maxPoints = 16;
		System.out.println("Введите игроков и их набранные очки. Игра ведётся до "+maxPoints+" очков.");
		String emptyLine = scanLine();
		String findWinner = scanLine();
		
		HashMap hm = new HashMap();
			
		String[] peopleList = findWinner.replace("\"", "").split(",");		
			
		for(int i = 0; i<peopleList.length;i++) {
			String Name = peopleList[i].trim().split(" ")[0];
			int points = Integer.parseInt(peopleList[i].trim().split(" ")[1]);
			int currentBalance;
				
			if(hm.containsKey(Name)) {
				currentBalance = ((Integer)hm.get(Name)).intValue();
			    hm.put(Name, currentBalance + points);
			}else {
				hm.put(Name, points);
			}
			currentBalance = ((Integer)hm.get(Name)).intValue();
			
			if(currentBalance>=maxPoints) {
				System.out.println(Name + " это победитель!");
				break;
			}	
		}
	}
}




