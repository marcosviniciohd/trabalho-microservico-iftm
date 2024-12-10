package br.com.relacionamento.no.sql.config;

import br.com.relacionamento.no.sql.models.Perfil;
import br.com.relacionamento.no.sql.models.Usuario;
import br.com.relacionamento.no.sql.repositories.PerfilRepository;
import br.com.relacionamento.no.sql.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

public class DataLoader {
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public DataLoader(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Object>> typeReference = new TypeReference<>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
            List<Object> data = mapper.readValue(inputStream, typeReference);

            for (Object obj: data) {
                if (obj instanceof Perfil) {
                    perfilRepository.save((Perfil) obj);
                } else if (obj instanceof Usuario) {
                    usuarioRepository.save((Usuario) obj);

                }
            }
        };
    }
}
