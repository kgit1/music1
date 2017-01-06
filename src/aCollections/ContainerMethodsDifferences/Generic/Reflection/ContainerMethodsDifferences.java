package aCollections.ContainerMethodsDifferences.Generic.Reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainerMethodsDifferences {

	// prints names of methods owned by class
	static Set<String> methodSet(Class<?> type) {
		// create set to hold results
		Set<String> result = new TreeSet<>();
		// iterate through set of classes methods of class returned by method -
		// getMethods()
		for (Method method : type.getMethods()) {
			// add interfaces names to holder set
			result.add(method.getName());
		}
		// return resulted set
		return result;
	}

	// prints names of interfaces owned by class
	static void interfaces(Class<?> type) {
		// print interfaces name
		System.out.println("Interfaces in " + type.getSimpleName());
		// create array list to hold results
		List<String> result = new ArrayList<>();
		// iterate through list of interfaces of class returned by method
		// getInterfaces()
		for (Class<?> c : type.getInterfaces()) {
			// add names of interfaces to holder list
			result.add(c.getSimpleName());
		}
		// print result
		System.out.println(result);
	}

	static Set<String> object = methodSet(Object.class);

	static {
		object.add("clone");
	}

	static void difference(Class<?> superset, Class<?> subset) {
		// print supersets and subsets names
		System.out.println(superset.getSimpleName() + " extends "
				+ subset.getSimpleName() + ", adds: ");
		// assign set of different methods between superset and subset
		Set<String> comp = Sets.difference(methodSet(superset),
				methodSet(subset));
		// remove all methods owned by Object
		comp.removeAll(object);
		// print interfaces of superset
		interfaces(superset);
	}

	public static void main(String[] args) {

		System.out.println("Collection: " + methodSet(Collection.class));
		interfaces(Collection.class);
		System.out.println();
		difference(Set.class, Collection.class);
		System.out.println();
		difference(HashSet.class, Set.class);
		System.out.println();
		difference(LinkedHashSet.class, HashSet.class);
		System.out.println();
		difference(TreeSet.class, Set.class);
		System.out.println();
		difference(List.class, Collection.class);
		System.out.println();
		difference(ArrayList.class, List.class);
		System.out.println();
		difference(LinkedList.class, List.class);
		System.out.println();
		difference(Queue.class, Collection.class);
		System.out.println();
		difference(PriorityQueue.class, Queue.class);
		System.out.println();
		System.out.println("Map: " + methodSet(Map.class));
		System.out.println();
		difference(HashMap.class, Map.class);
		System.out.println();
		difference(LinkedHashMap.class, HashMap.class);
		System.out.println();
		difference(SortedMap.class, Map.class);
		System.out.println();
		difference(TreeMap.class, Map.class);
	}
}

class Sets {
	// returns set consists of all members in a and b
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<>(a);
		result.addAll(b);
		return result;
	}

	// returns set consists of members contains both in a and b
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<>(a);
		result.retainAll(b);
		return result;
	}

	// returns set consists of members unique to a
	public static <T> Set<T> difference(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<>(a);
		result.removeAll(b);
		return result;
	}

	// returns set consists of member unique to a and b
	public static <T> Set<T> comlement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
}
