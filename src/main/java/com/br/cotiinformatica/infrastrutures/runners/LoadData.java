package com.br.cotiinformatica.infrastrutures.runners;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.br.cotiinformatica.domain.models.Perfil;
import com.br.cotiinformatica.infrastrutures.repositories.PerfilRepository;

@Component
public class LoadData implements ApplicationRunner {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Perfil perfil_default = new Perfil();
		perfil_default.setId(UUID.randomUUID());
		perfil_default.setNome("DEFAULT");
		
		Perfil perfil_admin = new Perfil();
		perfil_admin.setId(UUID.randomUUID());
		perfil_admin.setNome("ADMIN");
		
		if (perfilRepository.findByNome("DEFAULT") == null) {
			perfilRepository.save(perfil_default);
		}
		
		if (perfilRepository.findByNome("ADMIN") == null) {
			perfilRepository.save(perfil_admin);
		}
		
		
	}

}
