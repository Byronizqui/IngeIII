function ActaDecomiso(idDecomiso, policia, testigo, lugar, fecha, hora, interesado, decomisos, observaciones) {
    this.ActaDecomiso(idDecomiso, policia, testigo, lugar, fecha, hora, interesado, decomisos, observaciones);
}

ActaDecomiso.prototype = {
    idDecomiso: 0, 
    policia: "", 
    testigo: "", 
    lugar: "", 
    fecha: "", 
    hora: "", 
    interesado: "", 
    decomisos: "", 
    observaciones: "",
    ActaDecomiso: function (idDecomiso, policia, testigo, lugar, fecha, hora, interesado, decomisos, observaciones) {
        this.idDecomiso = idDecomiso;
        this.policia = policia;
        this.testigo = testigo; 
        this.lugar = lugar; 
        this.fecha=  fecha; 
        this.hora =  hora; 
        this.interesado = interesado; 
        this.decomisos =  decomisos; 
        this.observaciones = observaciones;
    }
};

ActaDecomiso.from = function (plain) {
    acta = new ActaDecomiso(
    plain.idDecomiso, 
    plain.policia, 
    plain.testigo, 
    plain.lugar, 
    plain.fecha, 
    plain.hora, 
    plain.interesado, 
    plain.decomisos, 
    plain.observaciones);
    return acta;
};

ActaDecomiso.to = function (acta) {
    return {
        _class: 'ActaDecomiso',
        idDecomiso: acta.idDecomiso, 
        policia: acta.policia, 
        testigo: acta.testigo, 
        lugar: acta.lugar, 
        fecha: acta.fecha, 
        hora: acta.hora, 
        interesado: acta.interesado, 
        decomisos: acta.decomisos, 
        observaciones: acta.observaciones
    };
};
 