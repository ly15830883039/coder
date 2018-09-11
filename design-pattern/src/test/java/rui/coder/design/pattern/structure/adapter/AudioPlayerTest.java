package rui.coder.design.pattern.structure.adapter;

import org.junit.jupiter.api.Test;
import rui.coder.design.pattern.structure.adapter.AudioPlayer;

class AudioPlayerTest {
    private AudioPlayer audioPlayer = new AudioPlayer();

    @Test
    void mp3() {
        audioPlayer.play("mp3", "beyond the horizon.mp3");
    }

    @Test
    void mp4() {
        audioPlayer.play("mp4", "alone.mp4");
    }

    @Test
    void vlc() {
        audioPlayer.play("vlc", "far far away.vlc");
    }

    @Test
    void avi() {
        audioPlayer.play("avi", "mind me.avi");
    }
}