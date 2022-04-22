import React, {useEffect, useState} from "react";
import StudentsList from "../presentational/StudentsList";
import StudentPresenterInstance from "../presenter/StudentPresenter";

const SmartStudentsList = () => {
    const [students, setStudents] = useState([]);

    const modifyStudents = (newStudents) => {
        setStudents([
            ...newStudents
        ])
    };

    useEffect(() => {
        StudentPresenterInstance.getStudents().then(modifyStudents);

        StudentPresenterInstance.on("event", modifyStudents)

        return () => {
            StudentPresenterInstance.removeListener("event", modifyStudents);
        }
    }, []);



    const onViewDetails = (id) => {
        window.location.assign("/#/student-details/" + id)
    };

    const onCreateStudent = () => {
        window.location.assign("/#/create-student")
    }

    return (
        <StudentsList
            students={students}
            title={"Students"}
            onCreateStudent={onCreateStudent}
            onViewDetails={onViewDetails}/>
    );
};

export default SmartStudentsList;