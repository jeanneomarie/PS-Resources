import {EventEmitter} from "events"
import WebSocketListenerInstance from "../ws/WebSocketListener";

class StudentModel extends EventEmitter{
    constructor() {
        super();
        this.state = {
            students: []
        };
        WebSocketListenerInstance.on("STUDENT_CREATED", event => {
            StudentModelInstance.addStudent(event.student);
            this.emit("event", this.state.students);
        })
    }

    addStudents(newStudents) {
        this.state.students = [
            ...newStudents
        ];
    }

    addStudent(newStudent) {
        this.state.students = [
            ...this.state.students,
            {
                ...newStudent
            }
        ];
    }

    getStudents() {
        return this.state.students;
    }
}

const StudentModelInstance = new StudentModel();

export default StudentModelInstance;