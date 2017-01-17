function Distrito(idDistrito, nombreDistrito) {
    this.Distrito(idDistrito, nombreDistrito);
}

Distrito.prototype = {
    idDistrito: 0, 
    nombreDistrito: "", 
    Distrito: function (idDistrito, nombreDistrito) {
        this.idDistrito = idDistrito, 
        this.nombreDistrito = nombreDistrito;
    }
};

Distrito.from = function (plain) {
    distrito = new Distrito(
    plain.idDistrito, 
    plain.nombreDistrito);
    return distrito;
};

Distrito.to = function (distrito) {
    return {
        _class: 'Distrito',
        idDistrito: distrito.idDistrito, 
        nombreDistrito : distrito.nombreDistrito
    };
};
 