import {EventEmitter} from "events"
import StudentModelInstance from "../model/StudentModel";
import RestClient from "../rest/RestClient";
import InvokerInstance from "../command/Invoker";
import AddStudentCommand from "../command/StudentCommands";

const client = new RestClient("teacher1", "password1");

class StudentPresenter extends EventEmitter {
    constructor() {
        super();
        StudentModelInstance.on("event", event => {
            this.emit("event", event)
        })
    }

    async addStudent(newStudent) {
        const student = await client.createStudent(newStudent.firstName, newStudent.lastName)
        //StudentModelInstance.addStudent(newStudent);
        InvokerInstance.invoke(new AddStudentCommand(newStudent))

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