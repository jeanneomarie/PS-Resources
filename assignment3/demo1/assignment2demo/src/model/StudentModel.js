class StudentModel {
    constructor() {
        this.state = {
            students: []
        };
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

// folosim Singleton Design Pattern
const StudentModelInstance = new StudentModel();

export default StudentModelInstance;