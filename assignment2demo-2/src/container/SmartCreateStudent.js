import React, {useState} from "react";
import CreateStudent from "../presentational/CreateStudent";
import StudentPresenterInstance from "../presenter/StudentPresenter";

function SmartCreateStudent() {
    const [newStudent, setNewStudent] = useState({
        firstName: "",
        lastName: ""
    });

    const onChange = (property, newValue) => {
        setNewStudent({
            ...newStudent,
            [property]: newValue
        });
    };

    const onCreate = () => {
        StudentPresenterInstance.addStudent(newStudent)
        window.location.assign("/#")
    }

    return (
        <CreateStudent
            firstName={newStudent.firstName}
            lastName={newStudent.lastName}
            onCreate={onCreate}
            onChange={onChange}/>
    );
}

export default SmartCreateStudent;