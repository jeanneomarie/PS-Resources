import StudentModelInstance from "../model/StudentModel";

class AddStudentCommand {
    constructor(newStudent) {
        this.newStudent = newStudent;
    }

    execute() {
        StudentModelInstance.addStudent(this.newStudent);
    }
}

export default AddStudentCommand;