package com.banckend.usersapi.infrastructure.input.rest;

import com.banckend.usersapi.application.dto.request.UserRequestDto;
import com.banckend.usersapi.application.dto.response.SuccesMessageResponseDto;
import com.banckend.usersapi.application.dto.response.UserResponseDto;
import com.banckend.usersapi.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Operaciones relacionadas con usuarios")
public class UserRestController {

    private final IUserHandler userHandler;

    @Operation(
            summary = "Crear un nuevo usuario",
            description = "Crea un usuario en el sistema a partir de los datos proporcionados",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Usuario creado exitosamente",
                            content = @Content(
                                    schema = @Schema(implementation = SuccesMessageResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Datos inválidos enviados en la solicitud",
                            content = @Content
                    )
            }
    )
    @PostMapping()
    public ResponseEntity<SuccesMessageResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userHandler.saveuser(userRequestDto));
    }

    @Operation(
            summary = "Obtener un usuario por su ID",
            description = "Devuelve la información del usuario correspondiente al ID proporcionado",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Usuario encontrado",
                            content = @Content(
                                    schema = @Schema(implementation = UserResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Usuario no encontrado",
                            content = @Content
                    )
            }
    )
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userHandler.getUserById(userId);
        return ResponseEntity.ok(userResponseDto);
    }
}
