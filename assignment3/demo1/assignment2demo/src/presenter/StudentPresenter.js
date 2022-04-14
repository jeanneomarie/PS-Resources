import StudentModelInstance from "../model/StudentModel";
import RestClient from "../rest/RestClient";

const client = new RestClient("teacher1", "password1");

class StudentPresenter {
    async addStudent(newStudent) {
        const student = await client.createStudent(newStudent.firstName, newStudent.lastName)
        StudentModelInstance.addStudent(newStudent);

        return student;
    }

    async getStudentById(id) {
        return client.findStudentById(id);
    }

    async getStudents() {
        const students = await client.loadAllStudents();
        StudentModelInstance.addStudents(students);

        return StudentModelInstance.getStudents();
    }
}

const StudentPresenterInstance = new StudentPresenter();

export default StudentPresenterInstance;