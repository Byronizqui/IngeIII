function Policia(identificacion, nombre, apellido1, apellido2, idPolicia) {
    this.Policia(identificacion, nombre, apellido1, apellido2, idPolicia);
}

Policia.prototype = {
    identificacion: "",
    nombre: "",
    apellido1: "",
    apellido2: "",
    idPolicia: 0,
    Policia: function (identificacion, nombre, apellido1, apellido2, idPolicia) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.idPolicia = idPolicia;
    }
};

Policia.from = function (plain) {
    policia = new Policia(
            plain.identificacion,
            plain.nombre,
            plain.apellido1,
            plain.apellido2,
            plain.idPolicia);
    return policia;
};

Policia.to = function (policia) {
    return {
        _class: 'Policia',
        identificacion: policia.idPolicia,
        nombre: policia.nombre,
        apellido1: policia.apellido1,
        apellido2: policia.apellido2,
        idPolicia: policia.idPolicia
    };
};
 