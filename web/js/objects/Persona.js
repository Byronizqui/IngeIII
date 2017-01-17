function Persona(identificacion, nombre, apellido1, apellido2, direccionExacta) {
    this.Persona(identificacion, nombre, apellido1, apellido2, direccionExacta);
}

Persona.prototype = {
    identificacion : "", 
    nombre : "", 
    apellido1 : "",
    apellido2 : "", 
    direccionExacta : "",
    Persona: function (identificacion, nombre, apellido1, apellido2, direccionExacta) {
        this.identificacion = identificacion, 
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccionExacta = direccionExacta;
    }
};

Persona.from = function (plain) {
    persona = new Persona(
        plain.identificacion, 
        plain.nombre, 
        plain.apellido1, 
        plain.apellido2, 
        plain.direccionExacta
    );
    return persona;
};

Persona.to = function (persona) {
    return {
        _class: 'Persona',
        identificacion : persona.identificacion, 
        nombre : persona.nombre, 
        apellido1 : persona.apellido1, 
        apellido2 : persona.apellido2, 
        direccionExacta : persona.direccionExacta
    };
};
 