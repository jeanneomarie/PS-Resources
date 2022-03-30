class StudentModel {
    constructor() {
        this.state = {
            students: [{
                firstName: "Ioana",
                lastName: "Onofrei",
                grades: [10, 10, 9]
            }, {
                firstName: "Liana",
                lastName: "Timar",
                grades: [10, 9, 9]
            }]
            //students: []
        };
    }

    // addStudents(newStudents) {
    //     this.state.students = [
    //         ...this.state.students,
    //         ...newStudents
    //     ];
    // }

    addStudent(newStudent) {
        this.state.students = [
            ...this.state.students,
            {
                ...newStudent,
                grades: []
            }
        ];
    }

    getStudentByIndex(index) {
        return this.state.students[index];
    }

    getStudents() {
        return this.state.students;
    }
}

// folosim Singleton Design Pattern
const StudentModelInstance = new StudentModel();

export default StudentModelInstance;