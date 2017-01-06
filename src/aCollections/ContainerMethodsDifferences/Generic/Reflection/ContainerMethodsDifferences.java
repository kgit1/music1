package aCollections.ContainerMethodsDifferences.Generic.Reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodsDifferences {

	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<>();
		for (Method method : type.getMethods()) {
			result.add(method.getName());
		}
		return result;
	}

	static void interfaces(Class<?> type) {
		System.out.println("Interfaces in " + type.getSimpleName());
		List<String> result = new ArrayList<>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
	}
}
