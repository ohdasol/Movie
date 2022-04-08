package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import moviedto.ActorDTO;
import moviedto.MovieCategori;

public class EndView {

	
	public static void projectView(MovieCategori project) {
		if (project != null) {
			System.out.println(project);
		} else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}

	public static void projectListView(ArrayList<MovieCategori> allProbonoProject) {
		if (allProbonoProject != null) {
			for (int i = 0; i < allProbonoProject.size(); i++) {
				if (allProbonoProject.get(i) != null) {
					System.out.println(allProbonoProject.get(i));
				}
			}
		} else {
			System.out.println("현 프로젝트는 미 존재 합니다.");
		}
	}

	public static void successView(String movieProject) {
		System.out.println(movieProject);
	}

	public static void moiveActorView(ActorDTO actorInfoRead) {
		System.out.println(actorInfoRead);
	}

	public static void HashName(HashMap<String, ArrayList<String>> actorInfoRead) {
	
		
		System.out.println(actorInfoRead.toString());
	}

//    public String toString() {
//        Iterator<Entry<K,V>> i = entrySet().iterator();
//        if (! i.hasNext())
//            return "{}";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('{');
//        for (;;) {
//            Entry<K,V> e = i.next();
//            K key = e.getKey();
//            V value = e.getValue();
//            sb.append(key   == this ? "(this Map)" : key);
//            sb.append('=');
//            sb.append(value == this ? "(this Map)" : value);
//            if (! i.hasNext())
//                return sb.append('}').toString();
//            sb.append(',').append(' ');
//        }
//    }
	
	
}	// Class End Point
