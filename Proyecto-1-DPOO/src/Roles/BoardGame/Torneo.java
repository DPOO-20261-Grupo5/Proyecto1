package BoardGame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Roles.Administrador;
import Roles.Cliente;
import Roles.Empleado;
import Roles.Usuario;

public class Torneo {

    public static final String AMISTOSO = "AMISTOSO";
    public static final String COMPETITIVO = "COMPETITIVO";

    // Atributos
    private int id;
    private LocalDate fecha;
    private String tipo;
    private int capacidadMaxima;
    private Juego juego;
    private Administrador administrador;
    private List<Inscripcion> inscritos;

    // Constructor
    public Torneo(int id, LocalDate fecha, String tipo, int capacidadMaxima, Juego juego, Administrador admin) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
        this.juego = juego;
        this.administrador = admin;
        this.inscritos = new ArrayList<>();
    }
    
    public int getId() {
    	return this.id;
    }
    
    public Administrador getAdministrador() {
    	return this.administrador;
    }


    public void inscribir(Usuario usuario, int cupos) throws Exception {

        if (cupos <= 0 || cupos > 3) {
            throw new Exception("Máximo 3 cupos por usuario");
        }

        
        if (usuario instanceof Empleado) {
            Empleado emp = (Empleado) usuario;
            if (emp.tieneTurno(fecha)) {
                throw new Exception("El empleado tiene turno ese día");
            }
        }

        int cuposOcupados = getTotalCuposOcupados();

        if (cuposOcupados + cupos > capacidadMaxima) {
            throw new Exception("No hay cupos suficientes");
        }

        boolean esFanatico = false;

        if (usuario instanceof Cliente) {
            Cliente c = (Cliente) usuario;
            esFanatico = c.getJuegosFavoritos().contains(juego);
        }

        Inscripcion ins = new Inscripcion(usuario, this, cupos, esFanatico);
        inscritos.add(ins);
    }



    public void desinscribir(Usuario usuario) {
        inscritos.removeIf(i -> i.getUsuario().equals(usuario));
    }


    public int getTotalCuposOcupados() {
        int total = 0;
        for (Inscripcion i : inscritos) {
            total += i.getCantidadCupos();
        }
        return total;
    }

    public int calcularCuposFanaticos() {
        return (int) Math.ceil(capacidadMaxima * 0.2);
    }



    public void otorgarPremio(Cliente ganador) {

        if (tipo.equals(AMISTOSO)) {
            Descuento d = new Descuento(10.0, false);
            ganador.agregarDescuento(d);
        }

        if (tipo.equals(COMPETITIVO)) {
            System.out.println("Premio monetario (externo)");
        }
    }



    public String getTipo() {
        return tipo;
    }

    public Juego getJuego() {
        return juego;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Inscripcion> getInscritos() {
        return inscritos;
    }
}
