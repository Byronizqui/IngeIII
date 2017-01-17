function Funcionario(identificacion, puesto, nombre, apellido1, apellido2, idFuncionario) {
    this.Funcionario(identificacion, puesto, nombre, apellido1, apellido2, idFuncionario);
}

Funcionario.prototype = {
    identificacion: "",
    puesto: "",
    nombre: "",
    apellido1: "",
    apellido2: "",
    idFuncionario: 0,
    Funcionario: function (identificacion, puesto, nombre, apellido1, apellido2, idFuncionario) {
        this.identificacion = identificacion;
        this.puesto = puesto;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.idFuncionario = idFuncionario;
    }
};

Funcionario.from = function (plain) {
    funcionario = new Funcionario(
            plain.identificacion,
            plain.puesto,
            plain.nombre,
            plain.apellido1,
            plain.apellido2,
            plain.idFuncionario);
    return funcionario;
};

Funcionario.to = function (funcionario) {
    return {
        _class: 'Funcionario',
        identificacion: funcionario.idFuncionario,
        puesto: funcionario.puesto,
        nombre: funcionario.nombre,
        apellido1: funcionario.apellido1,
        apellido2: funcionario.apellido2,
        idFuncionario: funcionario.idFuncionario
    };
};
 