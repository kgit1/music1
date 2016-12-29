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

	// method to return value of asked key
	// calls getFieldNumber method inside to get keys index or return exception
	// if not exists
	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}

	// method to set value to chosen key
	public Object setField(String id, Object value)
			throws DynamycFieldsException {
		// if transmitted by argument value = null - we call our exception
		// usually exception haven't constructors to take reason of exception
		// and if our exception haven't such constructor to
		// we can just call initCase() method available for all
		// subclasses of Throwable
		if (value == null) {
			DynamycFieldsException dfe = new DynamycFieldsException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		// initialize int fieldNumber with result of method hasField which
		// returns us index of key or -1 if not exists
		int fieldNumber = hasField(id);
		// if fieldNumber got -1, means field not exists - we call makeField
		// method wchich will add new key to our list, or if list full - will
		// create new 1 element bigger list, copy all data to it and put our new
		// key as the last element
		if (fieldNumber == -1) {
			fieldNumber = makeField(id);
		}
		// create object to hold result of our method
		Object result = null;
		try {
			// try to assign to result data sent by the getField method
			// to check one more time does key equals to id exists
			// because if not exists - means something gone wrong earlier in our
			// program
			// where we was supposed to recheck it and create new if not exists
			result = getField(id);
		} catch (NoSuchFieldException e) {
			// and if something gone wrong and we got here
			// this time we need to throw RuntimeExcetion
			// because if we there - we have serious error somewhere earlier
			// and we create new RuntimeException with constructor which can
			// take our exception as argument to have full data available
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}
}
