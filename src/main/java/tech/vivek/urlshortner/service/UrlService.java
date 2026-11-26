package tech.vivek.urlshortner.service;

import org.springframework.stereotype.Service;
import tech.vivek.urlshortner.dto.UrlRegisterDto;
import tech.vivek.urlshortner.dto.UrlRegisterResponseDto;
import tech.vivek.urlshortner.entity.UrlRegisterEntity;
import tech.vivek.urlshortner.exception.UrlExpiredException;
import tech.vivek.urlshortner.exception.UrlNotFoundException;
import tech.vivek.urlshortner.repository.UrlRepository;
import tech.vivek.urlshortner.utility.CodeGenerator;

import java.time.LocalDateTime;

@Service
public class UrlService {

    private UrlRepository urlRepository;
    private CodeGenerator codeGenerator;
    public UrlService(UrlRepository urlRepository, CodeGenerator codeGenerator) {
        this.urlRepository = urlRepository;
        this.codeGenerator = codeGenerator;
    }

    public UrlRegisterResponseDto createShortUrl(UrlRegisterDto urlRegisterDto) {
        UrlRegisterEntity urlRegisterEntity = UrlRegisterDtoToEntity(urlRegisterDto);
        UrlRegisterEntity registerEntity = urlRepository.save(urlRegisterEntity);
        return UrlRegisterEntityToDto(registerEntity);
    }


    public String redirectUrl(String short_code) {
        UrlRegisterEntity urlRegisterEntity = urlRepository.findByShortCode(short_code).orElseThrow(()->
                new UrlNotFoundException(short_code));
        if(urlRegisterEntity.getExpires_at().isBefore(LocalDateTime.now())){
            throw new UrlExpiredException();
        }
        urlRegisterEntity.setClick_count(urlRegisterEntity.getClick_count() + 1);
        urlRepository.save(urlRegisterEntity);
        return urlRegisterEntity.getOriginal_url();

    }




    private UrlRegisterEntity UrlRegisterDtoToEntity(UrlRegisterDto urlRegisterDto){
        UrlRegisterEntity urlRegisterEntity  = new UrlRegisterEntity();
        urlRegisterEntity.setOriginal_url(urlRegisterDto.getUrl());
        urlRegisterEntity.setShort_code(codeGenerator.generateCode());
        return urlRegisterEntity;
    }

    private UrlRegisterResponseDto UrlRegisterEntityToDto(UrlRegisterEntity urlRegisterEntity){
        UrlRegisterResponseDto urlRegisterResponseDto = new UrlRegisterResponseDto();
        urlRegisterResponseDto.setId(urlRegisterEntity.getId());
        urlRegisterResponseDto.setOriginal_url(urlRegisterEntity.getOriginal_url());
        urlRegisterResponseDto.setShort_code(urlRegisterEntity.getShort_code());
        urlRegisterResponseDto.setCreated_at(urlRegisterEntity.getCreated_at());
        urlRegisterResponseDto.setExpires_at(urlRegisterEntity.getExpires_at());
        return urlRegisterResponseDto;
    }



}
