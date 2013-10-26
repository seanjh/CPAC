public class Course {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;

	public Course(String courseName) {
		this.courseName = courseName;
		numberOfStudents = 0;
	}

	public String getCourseName() {
		return courseName;
	}

	public void addStudent(String student) {
		if (numberOfStudents == students.length) {
			String[] studensExtended = new String[students.length * 2];
			System.arraycopy(students, 0, studensExtended,
						0, students.length);
			students = studensExtended;
		}
		// Add the new student to the end of the Array
		students[numberOfStudents] = student;

		// Increment the students counter
		numberOfStudents++;
	}

	public void dropStudent(String student) {
		for (int i = 0; i < (numberOfStudents - 1); i++) {
			if (student.equals(students[i])) {
				numberOfStudents--;
				shiftStudents(i);
				break;
			}
		}
	}

	private void shiftStudents(int i) {
		// Shift each student 1 spot to the left from i
		for ( ; i < (numberOfStudents - 1); i++) {
			students[i] = students[i + 1];
		}
		// Return the extra spot in students to its default value
		students[numberOfStudents] = null;
	}

	public String[] getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}
}