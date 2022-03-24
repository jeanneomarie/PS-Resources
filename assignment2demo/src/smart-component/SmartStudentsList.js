import React, {useState} from "react";
import model from "../model/model"
import StudentsList from "../dumb-component/StudentsList";

function SmartStudentsList() {
    const [students, setStudents] = useState(model.state.students);
    const [newStudent, setNewStudent] = useState({
        firstName: model.state.newStudent.firstName,
        lastName: model.state.newStudent.lastName
    });

    const onChange = (property, newValue) => {
        setNewStudent({
            ...newStudent,
            [property]: newValue
        });
    };

    const onCreate = () => {
        setStudents([
            ...students,
            newStudent
        ])
    }

    const onCreateForTesting = () => {
        setStudents([
            ...students,
            {
                firstName: "test",
                lastName: "test"
            }
        ])
    }

    return (
        <StudentsList
            students={students}
            title={"Blabla"}
            firstName={newStudent.firstName}
            lastName={newStudent.lastName}
            onCreate={onCreate}
            onChange={onChange}/>
    );
}

export default SmartStudentsList;