package it.contrader.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.*;

@Data   //genera get e set
@AllArgsConstructor//genera il construct[lib lombok]
@NoArgsConstructor
@Entity			//associa classe tab db
@Table(name="User")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")  //preleva tutto da user
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdUser;

	@Column(name = "UserLogin")		//username
	@NotNull
	private String UserLogin;		//username

	@Column(name = "Password")
	@NotNull
	private String Password;
	
	@Nullable
	@Column(name = "NameUser")
	private String NameUser;

	@Nullable
	@Column(name = "SurnameUser")
	private String SurnameUser;
	
	@NotNull
	@Column(name = "Azienda")
	private String Azienda;

	@NotNull
	@Column(name = "UserType")
	private String UserType;
	
	@OneToMany(mappedBy="User")
	private List<Project> Projects;
		
}
