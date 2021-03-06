package pockemon.api.rest.dtos;

import java.util.List;
import java.util.stream.Collectors;

import pockemon.api.rest.dtos.pocke.client.PokeDetailClientDTO;

public class PokemonDTO {

	private final String URL_BASE_TO_DETAIL = "https://json-pokemon-api.herokuapp.com/pokemon/v1/%s/detail";
	
	private Integer id;
	private String imageUrl;
	private String detailUrl;
	private String name;
	private String weight;
	
	private List<String> types;
	private List<String> abilities;
	
	public PokemonDTO() {
		super();
	}

	public PokemonDTO(Integer id, String imageUrl, String name, String weight, List<String> types, List<String> abilities) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.detailUrl = String.format(URL_BASE_TO_DETAIL, id);
		this.name = name;
		this.weight = weight;
		this.types = types;
		this.abilities = abilities;
	}

	public PokemonDTO(final PokeDetailClientDTO pokemonDetail) {
		super();		
		this.id = pokemonDetail.getId();
		this.imageUrl = pokemonDetail.getSprites().getFront_default();
		this.detailUrl = String.format(URL_BASE_TO_DETAIL, id);
		this.name = pokemonDetail.getName();
		this.weight = pokemonDetail.getWeight();
		this.types = pokemonDetail.getAbilities().stream().map(ability -> ability.getAbilityName().getName())
				.collect(Collectors.toList());
		this.abilities = pokemonDetail.getTypes().stream().map(type -> type.getTypeName().getName())
				.collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public String getDetailUrl() {
		return detailUrl;
	}

	public String getName() {
		return name;
	}

	public String getWeight() {
		return weight;
	}

	public List<String> getTypes() {
		return types;
	}

	public List<String> getAbilities() {
		return abilities;
	}

	@Override
	public String toString() {
		return "PokemonDTO [id=" + id + ", imageUrl=" + imageUrl + ", detailUrl=" + detailUrl + ", name=" + name
				+ ", weight=" + weight + ", types=" + types + ", abilities=" + abilities + "]";
	}
	
}
