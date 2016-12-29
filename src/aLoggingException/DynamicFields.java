package aLoggingException;

class DynamycFieldsException extends Exception {
}

public class DynamicFields {

	// create multidimensional array of Objects
	// our DynamicFields Object will consist of array of pairs of objects
	private Object[][] fields;

	// constructor creates array fields with size initialSize
	public DynamicFields(int initialSize) {
		// create array fields with size initialSize with every element consists
		// of array of two elements
		fields = new Object[initialSize][2];
		// initialize all elements of "second-layer" arrays with nulls
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new Object[] { null, null };
		}
	}

	// create toString method to return elements of our DynamicFields Object
	public String toString() {
		StringBuilder result = new StringBuilder();
		// iterate through our DynamicFields Object
		for (Object[] obj : fields) {
			// add first element of pair
			result.append(obj[0]);
			// add separator
			result.append(": ");
			// add second element
			result.append(obj[1]);
			// add next string pointer
			result.append("\n");
		}
		// return all our pairs
		return result.toString();
	}

	// method returns index of the key(the first element of pair) if such exists
	// in our list, else returns -1
	private int hasField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if (id.equals(fields[i][0])) {
				return i;
			}
		}
		return -1;
	}

	// method returns index of the key(the first element of pair) if such exists
	// in our list, else throws NoSuchFieldException
	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if (fieldNum == -1) {
			throw new NoSuchFieldException();
		}
		return fieldNum;
	}

	// method makes new key in our list
	private int makeField(String id) {
		// iterate through our list trying to find empty field
		// if empty found - assign id to it, and return it's index
		for (int i = 0; i < fields.length; i++) {
			if (fields[i][0] == null) {
				fields[i][0] = id;
				return i;
			}
		}
		// else create new multidimensional array of Objects with
		// fields.length+1
		// containing arrays of pairs of objects
		Object[][] tmp = new Object[fields.length + 1][2];

		// copy our list fields to new array
		for (int i = 0; i < fields.length; i++) {
			tmp[i] = fields[i];
		}
		// initialize last(new) element in new array with objects array consists
		// of pair of elements
		for (int i = fields.length; i < tmp.length; i++) {
			tmp[i] = new Object[][] { null, null };
		}
		// recursive call our method second time to finish adding item to list
		return makeField(id);
	}

}
