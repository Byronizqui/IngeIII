function Decomiso(idDecomiso, nombre, cantidad, observaciones) {
    this.Decomiso(idDecomiso, nombre, cantidad, observaciones);
}

Decomiso.prototype = {
    idDecomiso: 0, 
    nombre: "", 
    cantidad: 0,
    observaciones: "",
    Decomiso: function (idDecomiso, nombre, cantidad, observaciones) {
        this.idDecomiso = idDecomiso;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }
};

Decomiso.from = function (plain) {
    decomiso = new Decomiso(
    plain.idDecomiso, 
    plain.nombre,
    plain.cantidad,
    plain.observaciones);
    return decomiso;
};

Decomiso.to = function (decomiso) {
    return {
        _class: 'Decomiso',
        idDecomiso: decomiso.idDecomiso, 
        nombre : decomiso.decomiso,
        cantidad : decomiso.cantidad,
        observaciones: decomiso.observaciones
    };
};
 