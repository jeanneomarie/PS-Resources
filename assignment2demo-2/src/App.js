import React from "react";
import './App.css';
import {HashRouter, Routes, Route} from "react-router-dom";
import SmartStudentDetails from "./container/SmartStudentDetails";
import SmartCreateStudent from "./container/SmartCreateStudent";
import SmartStudentsList from "./container/SmartStudentsList";

function App() {
    return <div className="App">
        <HashRouter>
            <Routes>
                <Route exact={true} element={<SmartStudentsList/>} path="/" />
                <Route exact={true} element={<SmartCreateStudent/>} path="/create-student" />
                <Route exact={true} element={<SmartStudentDetails/>} path="/student-details/:index" />
            </Routes>
        </HashRouter>
    </div>
}

export default App;
