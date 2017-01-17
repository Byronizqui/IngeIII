function Lugar(distrito, direccionExacta) {
    this.Lugar(distrito, direccionExacta);
}

Lugar.prototype = {
    distrito : "",
    direccionExacta: "",
    Lugar: function (distrito, direccionExacta) {
        this.distrito = distrito, 
        this.direccionExacta = direccionExacta;
    }
};

Lugar.from = function (plain) {
    lugar = new Lugar(
        plain.distrito, 
        plain.direccionExacta
    );
    return lugar;
};

Lugar.to = function (lugar) {
    return {
        _class: 'Lugar',
        distrito: lugar.distrito, 
        direccionExacta : lugar.direccionExacta
    };
};
 