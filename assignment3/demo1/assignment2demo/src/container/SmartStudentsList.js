import React, {useEffect, useState} from "react";
import StudentsList from "../presentational/StudentsList";
import StudentPresenterInstance from "../presenter/StudentPresenter";

const SmartStudentsList = () => {
    const [students, setStudents] = useState([]);

    // old version
    // detecteaza schimbari
    // similar cu componentDidMount/componentDidUpdate din React
    // sau din Angular cu ngOnInit + ngOnChanges
    // useEffect(() => {
    //     setStudents([
    //         ...StudentPresenterInstance.getStudents()
    //     ])
    // }, []);

    // daca avem timp facem si asta
    // dumb version for the moment
    // useEffect(async () => {
    //     const foundStudents = await StudentPresenterInstance.getStudents();
    //     console.log(foundStudents)
    //     setStudents([
    //         ...foundStudents
    //     ])
    // }, []);

    // another version
    useEffect(() => {
        StudentPresenterInstance.getStudents().then(foundStudents => {
            setStudents([
                ...foundStudents
            ])
        });
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