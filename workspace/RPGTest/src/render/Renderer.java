package render;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import assets.AnimatedNinePatch;
import assets.AnimatedSprite;
import assets.NinePatchImage;
import head.ProgramState;

import static render.RenderingHandler.*;

public abstract class Renderer {
	public abstract void loadSpecificResources();
	public abstract void mobileRender();
	public abstract void staticRender();
	public ProgramState state = ProgramState.DEFAULT;
	private boolean defCentered = false;
	private boolean defSmooth = false;
	private int defRotation = 0;
	private float defOpacity = 1.0f;
	
	public Renderer(ProgramState s){
		state = s;
	}
	
	protected void drawAnimatedSprite(AnimatedSprite a){
		Sprite s = a.getSprite();
		drawAnimatedSprite(a, s.getX(), s.getY(), s.getWidth(), s.getHeight());
	}
	
	protected void drawAnimatedSprite(AnimatedSprite a, float x, float y, float w, float h){
		drawAnimatedSprite(a, x, y, w, h, defRotation);
	}
	
	protected void drawAnimatedSprite(AnimatedSprite a, float x, float y, float w, float h, int rotation){
		drawAnimatedSprite(a, x, y, w, h, rotation, defSmooth, Color.WHITE, defOpacity, defCentered);
	}
	
	protected void drawAnimatedSprite(AnimatedSprite a, Rectangle r, int rotation){
		drawAnimatedSprite(a, r.x, r.y, r.width, r.height, rotation);
	}
	
	protected void drawAnimatedSprite(AnimatedSprite a, Rectangle r){
		drawAnimatedSprite(a, r.x, r.y, r.width, r.height, defRotation);
	}

    protected void drawAnimatedSprite(AnimatedSprite a, Rectangle r, int rotation, boolean smooth, Color tint, float opacity, boolean centered) {
    	drawAnimatedSprite(a, r.x, r.y, r.width, r.height, rotation, smooth, tint, opacity, centered);
    }
	
	protected void drawAnimatedSprite(AnimatedSprite a, float x, float y, float w, float h, int rotation, boolean smooth, Color tint, float opacity, boolean centered){
		drawImage(a.getSprite(), x, y, w, h, rotation, smooth, tint, opacity, centered);
	}
	
	protected void drawAnimatedSprite(AnimatedSprite a, float x, float y, float scale, int rotation, boolean smooth, Color tint, float opacity, boolean centered){
		drawImage(a.getSprite(), x, y, scale, rotation, smooth, tint, opacity, centered);
	}

    protected void drawImage(Sprite sprite, float x, float y, float w, float h) {
    	drawImage(sprite, x, y, w, h, defRotation, defSmooth, Color.WHITE, defOpacity, defCentered);
    }

    protected void drawImage(Sprite sprite, float x, float y, float w, float h, int rotation) {
    	drawImage(sprite, x, y, w, h, rotation, defSmooth, Color.WHITE, defOpacity, defCentered);
    }

    protected void drawImage(Sprite sprite, Rectangle r, int rotation) {
    	drawImage(sprite, r.x, r.y, r.width, r.height, rotation);
    }

    protected void drawImage(Sprite sprite, Rectangle r) {
    	drawImage(sprite, r.x, r.y, r.width, r.height);
    }

    protected void drawImage(Sprite sprite, Rectangle r, int rotation, boolean smooth, Color tint, float opacity, boolean centered) {
    	drawImage(sprite, r.x, r.y, r.width, r.height, rotation, smooth, tint, opacity, centered);
    }
	
    protected void drawImage(Sprite sprite, float x, float y, float scale, int rotation, boolean smooth, Color tint, float opacity, boolean centered) {
    	if(smooth){
    		sprite.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	}else{
    		sprite.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	}
    	if(!centered){
    		x += sprite.getWidth() / 2;
    		y += sprite.getHeight() / 2;
    	}
    	sprite.setSize(1, 1);
    	sprite.setScale(scale);
    	sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
    	sprite.setPosition(x - (sprite.getWidth() / 2), y - (sprite.getHeight() / 2));
    	sprite.setRotation(rotation);
    	sprite.setColor(tint.r, tint.g, tint.b, opacity);
    	actualDrawImage(sprite);
    }
    
    protected void drawImage(Sprite sprite, float x, float y, float w, float h, int rotation, boolean smooth, Color tint, float opacity, boolean centered) {
    	if(smooth){
    		sprite.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	}else{
    		sprite.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	}
    	if(!centered){
    		x += w / 2;
    		y += h / 2;
    	}
    	sprite.setSize(1, 1);
    	sprite.setScale(w, h);
    	sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
    	sprite.setPosition(x - (sprite.getWidth() / 2), y - (sprite.getHeight() / 2));
    	sprite.setRotation(rotation);
    	sprite.setColor(tint.r, tint.g, tint.b, opacity);
    	actualDrawImage(sprite);
    }
    
    private void actualDrawImage(Sprite sprite){
    	sprite.draw(batch);
    }

    protected void drawString(String string, Rectangle r, LabelStyle style, float opacity) {
    	drawString(string, r.x, r.y, style, opacity);
    }

    protected void drawString(String string, float x, float y, LabelStyle style, float opacity) {
    	y -= style.font.getCapHeight();
        Label lab = new Label(string, style);
        lab.setPosition(x, y);
        lab.draw(batch, opacity);
    }
    
    protected void drawNinePatch(NinePatch img, float x, float y, float width, float height, Color tint){
    	img.setColor(tint);
    	img.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	img.draw(batch, x, y, width, height);
    }
    
    protected void drawNinePatch(NinePatch img, Rectangle box, Color tint){
    	img.setColor(tint);
    	img.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
    	img.draw(batch, box.x, box.y, box.width, box.height);
    }
    
    protected void drawNinePatch(NinePatch n, float x, float y, float w, float h){
    	drawNinePatch(n, x, y, w, h, Color.WHITE);
    }
    
    protected void drawNinePatches(ArrayList<NinePatch> nps, int x, int y, int w, int h){
    	for(int i = 0; i < nps.size(); i++){
    		drawNinePatch(nps.get(i), x, y, w, h);
    	}
    }
    
    protected void drawAnimatedNinePatch(AnimatedNinePatch a){
    	drawNinePatchImage(a.getImage());
    }
    
    protected void drawNinePatchImage(NinePatchImage n){
    	drawNinePatch(n.N, n.BOX.x, n.BOX.y, n.BOX.width, n.BOX.height);
    }
    
    protected void drawNinePatchImages(ArrayList<NinePatchImage> nps){
    	for(int i = 0; i < nps.size(); i++){
    		NinePatchImage n = nps.get(i);
    		drawNinePatchImage(n);
    	}
    }
}
