package ubc.cs304.gametrack.controllers.postalcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.PostalCode;

import java.util.List;

@Service
public class PostalCodeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createPostalCode(PostalCode postalCode) {

        jdbcTemplate.update( "INSERT INTO PostalCode (postal_code,province,city) VALUES (?,?,?)",
        postalCode.getPostal_code(),
        postalCode.getProvince(),
        postalCode.getPostal_code());

    }

    @SuppressWarnings("unchecked")
    List<PostalCode> findAllPostalCodes() {
        return jdbcTemplate.query("SELECT postal_code,province,city FROM PostalCode;",
                new BeanPropertyRowMapper(PostalCode.class));
    }

    PostalCode findPostalCodeBy(String postal_code) {
        List<PostalCode> postalCodes = findAllPostalCodes();
        return postalCodes.stream().filter(pc -> pc.getPostal_code().equals(postal_code)).findFirst().orElse(new PostalCode());
    }
}
