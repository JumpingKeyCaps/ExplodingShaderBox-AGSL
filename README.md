# Exploding Shader Box (AGSL / Jetpack Compose)


![Platform](https://img.shields.io/badge/platform-Android-3DDC84?logo=android&logoColor=white)
![Language](https://img.shields.io/badge/language-Kotlin-7F52FF?logo=kotlin&logoColor=white)
![UI](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?logo=jetpackcompose&logoColor=white)
![Shader](https://img.shields.io/badge/AGSL-RuntimeShader-black)
![Min SDK](https://img.shields.io/badge/min%20sdk-33-blue)
![Use Case](https://img.shields.io/badge/use--case-Premium%20Destructive%20UI-critical)


A high-impact AGSL shader designed for **visual destruction**, not decoration.

This shader is meant to accompany **irreversible or premium actions** in a Compose UI by visually destroying the rendered content in a controlled, readable way.

---

## Concept

The Exploding Shader Box applies a multi-phase explosion effect to **everything rendered inside a Compose Box**, regardless of content type:

- Image
- Text
- LazyColumn
- WebView
- Video
- Mixed Compose UI

The shader operates at **render level**, not composable level.  
It destroys what is actually displayed on screen, without fake layers or duplicated content.

This is not a visual effect for fun.
It is a **visual consequence**.

---

## Intended Use Cases

- Premium delete actions
- Irreversible confirmation
- Destructive reset
- Full wipe
- End-of-flow transitions
- Actions with no return path

Not recommended for:
- Decorative animations
- Continuous effects
- Scroll-time effects
- Reusable UI feedback

---

## Architecture Overview

### MinimalShaderBox

A generic Compose container that:

- Loads an AGSL shader from `res/raw`
- Uses `RuntimeShader` + `RenderEffect`
- Forwards dynamic uniforms
- Captures user interaction (tap / press)
- Drives a single normalized progress value `[0 → 1]`

All child content is rendered **through the shader**.

---

### Shader Structure (AGSL)

The shader is built as a **three-phase visual narrative**:

#### Phase 1 - Shockwave
- Circular ripple
- Spatial distortion
- Flash highlight
- Heat haze behind the wave

#### Phase 2 - Transition
- Progressive deformation
- Chromatic aberration
- Controlled blend between wave and explosion

#### Phase 3 - Fragmentation
- Stable Voronoi fragmentation
- Individual fragment projection
- Rotation and skew
- Shadowing and depth
- Micro debris (sparkles)
- Final dissipation

Fragments are **stable over time**, ensuring clarity instead of chaotic noise.

---

## Core Usage Rule

> The shader destroys **everything inside its Box**.

This is a hard rule.

### Consequences

- ShaderBox around a full screen  
  → global destruction

- ShaderBox around a single item  
  → local destruction

There is no partial scope or exception.

---

## Recommended Usage Patterns

### Local Destruction (Lists)

For `LazyColumn` or lists:

- Do not wrap the entire list
- Each removable item must have its **own ShaderBox**

Result:
- One item explodes
- Other items remain intact
- Layout updates normally after removal

---

### Global Destruction

Use only for:
- Full reset
- Screen wipe
- End-state confirmation

Wrap the entire screen in a single ShaderBox.

---

## Demo Provided

### ExplodableBoxDemo

A simple fullscreen demo showing:

- A content-filled ShaderBox
- Tap interaction triggering the explosion
- Full visual destruction followed by reset

This demo exists for **technical validation**, not UX recommendation.

---

## Main Shader Uniforms

- `resolution`  
  Size of the shader container

- `contentSize`  
  Actual measured size of child content (used for clean clipping)

- `explosionCenter`  
  Interaction position in screen space

- `explosionProgress`  
  Normalized progress value `[0 → 1]`

- `interactionPhase`  
  Allows full bypass or activation of the shader

---

## Performance Notes

- Heavy shader (loops, Voronoi, multiple samples)
- Intended for rare interactions
- Not suitable for continuous animations
- Avoid applying to large scrolling surfaces

The cost is intentional and justified by the narrative impact.

---

## Design Philosophy

Most UIs delete without consequence.
They remove content silently.

This shader does the opposite:
it makes the action **felt**.

Visual destruction communicates finality better than any dialog.

---

## Summary

- A destruction shader, not a decoration
- Works with any Compose-rendered content
- Local or global based on container placement
- Ideal for premium or irreversible actions
- Should be used rarely, but intentionally
