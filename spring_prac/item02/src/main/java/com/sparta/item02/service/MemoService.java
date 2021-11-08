package com.sparta.item02.service;

import com.sparta.item02.domain.Memo;
import com.sparta.item02.domain.MemoRepository;
import com.sparta.item02.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디 x")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}
