import StudentModelInstance from "../model/studentModel";

class StudentPresenter {
    addStudent(newStudent) {
        return StudentModelInstance.addStudent(newStudent);
    }

    getStudentByIndex(index) {
        return StudentModelInstance.getStudentByIndex(index);
    }

    getStudents() {
        return StudentModelInstance.getStudents();
    }
}

const StudentPresenterInstance = new StudentPresenter();

export default StudentPresenterInstance;