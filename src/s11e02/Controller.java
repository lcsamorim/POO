/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11e02;

import java.util.Map;

class Paciente{
	String id;
	   Map<String, Medico> medicos;
	void addMedico(Medico medico) {
		Medico pmedico = medicos.get(medico.id);
		if(pmedico != null)
			return;
		medicos.put(medico.id, medico);
		medico.addPaciente(this);
	}
	
}
class Medico{
	String id;
	Map<String, Paciente> pacientes;
	void addPaciente(Paciente paciente) {
		Paciente mpaciente = pacientes.get(paciente.id);
		if(mpaciente != null)
			return;
		pacientes.put(paciente.id, paciente);
		paciente.addMedico(this);
	}
        
}

public class Controller {

}

