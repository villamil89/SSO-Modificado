package sic.autenticarda.service;

import sic.autenticarda.model.dto.UserResponseDTO;

public interface IClientService {

	UserResponseDTO login(String username, String password) throws Exception;

}