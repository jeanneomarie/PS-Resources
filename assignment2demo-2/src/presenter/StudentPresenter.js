import StudentModelInstance from "../model/studentModel";

class StudentPresenter {
    addStudent(newStudent) {
        //in assignment3 aici o sa adaugam call-urile catre backend
        return StudentModelInstance.addStudent(newStudent);
    }

    getStudentByIndex(index) {
        return StudentModelInstance.getStudentByIndex(index);
    }

    getStudents() {
        return StudentModelInstance.getStudents();
    }

    // in caz ca apucam va arat si un sneak peek din ce vom face la assignment 3
    // async getStudents() {
    //     return new Promise((resolve, reject) => {
    //       StudentModelInstance.addStudents([{
    //               firstName: "Ioana",
    //               lastName: "Onofrei",
    //               grades: [10, 10, 9]
    //           }, {
    //               firstName: "Liana",
    //               lastName: "Timar",
    //               grades: [10, 9, 9]
    //           }]);
    //       resolve(StudentModelInstance.getStudents())
    //     })
    // }
}

const StudentPresenterInstance = new StudentPresenter();

export default StudentPresenterInstance;