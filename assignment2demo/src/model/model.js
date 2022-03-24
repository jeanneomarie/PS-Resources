class Model {
    constructor() {
        this.state = {
            students: [{
                firstName: "Ioana",
                lastName: "Onofrei"
            }, {
                firstName: "Maria",
                lastName: "Onofrei"
            }],
            newStudent: {
                firstName: "",
                lastName: ""
            }
        };
    }
}

const model = new Model();

export default model;