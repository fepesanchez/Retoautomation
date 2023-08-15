package Models;

public enum EnumData {

    paisResidencia("País de residencia"),
    zonaHoraria("Zona horaria"),
    paisProcedencia("País de procedencia"),
    teamLeader("Team leader"),
    lenguajes("Idiomas"),
    trainerRoutes("Rutas del trainer");

    private final String valor;

    EnumData(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
