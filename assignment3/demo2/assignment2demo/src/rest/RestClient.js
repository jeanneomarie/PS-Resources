const BASE_URL = "http://localhost:8080";

class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    loadAllStudents = () => {
        return fetch(`${BASE_URL}/students`, {
            method: "GET",
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }

    findStudentById = (id) => {
        return fetch(`${BASE_URL}/students/${id}`, {
            method: "GET",
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }

    createStudent = (firstName, lastName) => {
        return fetch(`${BASE_URL}/students`, {
            method: "POST",
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }
}

export default RestClient;