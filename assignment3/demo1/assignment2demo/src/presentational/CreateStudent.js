import React from "react"

const CreateStudent = ({firstName, lastName, onCreate, onChange}) => (
    <div>
        <h2>Create Student</h2>
        <div>
            <label>First Name: </label>
            <input value={firstName}
                   onChange={e => onChange("firstName", e.target.value)}/>
            <br/>
            <label>Last Name: </label>
            <input value={lastName}
                   onChange={e => onChange("lastName", e.target.value)}/>
            <br/>
            <button className={"btn btn-success"} onClick={onCreate}>Create!</button>
        </div>
    </div>
);

export default CreateStudent;