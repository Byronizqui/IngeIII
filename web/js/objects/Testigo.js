function Testigo(idTestigo,identificacion,nombre,apellido1,apellido2) {
    this.Testigo(idTestigo,identificacion,nombre,apellido1,apellido2);
}

Testigo.prototype = {
    idTestigo : 0, 
    identificacion : " " ,
    nombre : " ",
    apellido1 : " ",
    apellido2 : " ",
    Testigo: function (idTestigo, identificacion,nombre,apellido1,apellido2) {
        this.idTestigo = idTestigo;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
};

Testigo.from = function (plain) {
    testigo = new Testigo(
        plain.idTestigo,
        plain.identificacion,
        plain.nombre,
        plain.apellido1,
        plain.apellido2
    );
    return testigo;
};

Testigo.to = function (testigo) {
    return {
        _class: 'Testigo',
        idTestigo : testigo.idTestigo,
        identificacion : testigo.identificacion,
        nombre : testigo.nombre,
        apellido1 : testigo.apellido1,
        apellido2 : testigo.apellido2
    };
};
 