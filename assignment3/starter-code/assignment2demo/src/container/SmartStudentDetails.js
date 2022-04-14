import React, {useEffect, useState} from "react";
import StudentDetails from "../presentational/StudentDetails";
import {useParams} from "react-router-dom";
import StudentPresenterInstance from "../presenter/StudentPresenter";

const SmartStudentDetails = () => {
    const [student, setStudent] = useState({
        firstName: "",
        lastName: "",
        grades: []
    });
    const {index} = useParams();

    useEffect(() => {
        setStudent(StudentPresenterInstance.getStudentByIndex(index))
    }, []);

    return (
        <StudentDetails firstName={student.firstName}
                        lastName={student.lastName}
                        grades={student.grades}/>
    );
}

export default SmartStudentDetails;