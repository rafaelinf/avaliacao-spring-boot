package br.com.tokiomarine.seguradora.avaliacao.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class MapperUtils {

	public static <T, V> List<T> convertListToDto(List<V> list, Type destinationType) {

		List<T> listDto = new ArrayList<T>();

		if (list != null && !list.isEmpty()) {
			for (V objectSource : list) {
				T objectDTO = (T) convertToDto(objectSource, destinationType);
				if (objectDTO != null) {
					listDto.add(objectDTO);
				}
			}
		}

		return listDto;
	}

	public static <T, V> Object convertToDto(V object, Type destinationType) {
		ModelMapper modelMapper = new ModelMapper();

		T dto = null;

		if (object != null) {
			dto = modelMapper.map(object, destinationType);
		}

		return dto;
	}

}
