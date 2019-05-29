package it.contrader.converter;

public interface Converter<T,V> {
	public T toEntity(V v);
	public V toDTO(T t);
}
